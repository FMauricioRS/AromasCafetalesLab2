package com.fmauriciors.aromascafetaleslab2.ui.repositorybdac

import com.fmauriciors.aromascafetaleslab2.ui.ProductProject
import com.fmauriciors.aromascafetaleslab2.ui.local.Product;
import com.fmauriciors.aromascafetaleslab2.ui.local.ProductDao
import java.sql.Types.NULL

class ProductRepository {
    suspend fun saveProduct(
        productName: String,
        cost: String,
        resumePlantation: String

    ) {
        val product = Product(

            id = Types.NULL,
            productName = productName,
            cost = cost,
            resumePlantation = resumePlantation
        )

        val productDao : ProductDao = ProductProject.database.ProductDao()
        productDao.saveProduct(product)
    }
/*
suspend fun searchBook(nameBook: String): Book {
    val bookDao: BookDao = BookProject.database.BookDao()
    val  book= bookDao.searchBook(nameBook)
    return book
}

suspend fun deleteBook(book: Book) {
    val bookDao: BookDao = BookProject.database.BookDao()
    bookDao.deleteBook(book)
}*/

    suspend fun loadProducts(): ArrayList<Product>{
        val productDao: ProductDao = ProductProject.database.ProductDao()
        val productList : ArrayList<Product> = productDao.loadProducts() as ArrayList<Product>
        return productList

    }







}