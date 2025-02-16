package com.example.login01



import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var bookListView: ListView
    private lateinit var bookAdapter: BookAdapter
    private val books = mutableListOf<Book>()
    private val history = mutableListOf<Book>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize books
        books.add(Book(R.drawable.image01, "Android from Beginner to Master", "Very well written."))
        books.add(Book(R.drawable.image02, "C++ Programming Language", "Excellent writing."))
        books.add(Book(R.drawable.image03, "Project-Based Introduction to Programming Paperback", "Python Crash Course, 3rd Edition: A Hands-On, Project-Based Introduction to Programming Paperback"))

        bookListView = findViewById(R.id.bookListView)
        bookAdapter = BookAdapter(this, books)
        bookListView.adapter = bookAdapter

        // Set item click listener
        bookListView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            val selectedBook = books[position]
            history.add(selectedBook) // Add to history
            showBookDetails(selectedBook)
        }

        // History button click listener
        findViewById<View>(R.id.historyButton).setOnClickListener {
            val intent = Intent(this, HistoryActivity::class.java)
            intent.putExtra("history", history.toTypedArray())
            startActivity(intent)
        }
    }

    private fun showBookDetails(book: Book) {
        val intent = Intent(this, BookDetailActivity::class.java)
        intent.putExtra("book", book)
        startActivity(intent)
    }
}