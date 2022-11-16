package com.codeplace.myapplication.ui.activitys
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codeplace.myapplication.R
import com.codeplace.myapplication.models.Book
import com.codeplace.myapplication.ui.recyclerview.adapter.BookListAdapter
import com.codeplace.myapplication.webclient.services.RetrofitInstance
import com.codeplace.myapplication.webclient.services.models.BookResponse
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response


var book : List<Book> = listOf()

class MainActivity : AppCompatActivity()  {

    companion object{
        val INTENT_PARCELABLE = "OBJECT_INTENT "
     }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initValues()
    }


    fun initValues(){
        getBooks()

    }

    fun getBooks() {
        lifecycleScope.launch(IO) {
                val call: Call<List<BookResponse>> = RetrofitInstance().bookService.getAllBooks()
                // Executando a execucao para puxar os dados da web api, o qual tera uma resposta.
                val response: Response<List<BookResponse>> = call.execute()
                // Com a resposta, teremos acesso ao corpo desta resposta
                // Por esta resposta poder ser um nullable, utilizamos o let para termos acesso aos livros
                response.body()?.let { bookResponses ->
                    //Log.i("BookList:","on create $bookResponses" )
                    book = bookResponses.map {
                        it.book
                    }
                }
            runOnUiThread { initAdapter(book) }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun initAdapter(book:List<Book>) {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter =  BookListAdapter(book, this){
            val intent = Intent(this, BookDetailActivity::class.java)
            intent.putExtra(INTENT_PARCELABLE, it)
            startActivity(intent) }
    }
}

