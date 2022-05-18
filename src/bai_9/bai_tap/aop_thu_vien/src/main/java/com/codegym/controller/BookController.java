package com.codegym.controller;

import com.codegym.exception.RunoutQuantity;
import com.codegym.model.Book;
import com.codegym.model.BookLendVoucher;
import com.codegym.service.IBookLendVoucherService;
import com.codegym.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BookController {
    @Autowired
    private IBookService iBookService;
    @Autowired
    private IBookLendVoucherService iBookLendVoucherService;

    @GetMapping("/home")
    public String goHome(Model model) {
        model.addAttribute("bookList", iBookService.findAll());
        return "list";
    }

    @GetMapping(value = "/addBook")
    public String goAddBook(Model model) {
        model.addAttribute("book", new Book());
        return "/create";
    }

    @PostMapping(value = "/addNewBook")
    public String addNewBook(Book book) {
        iBookService.save(book);
        return "redirect:/home";
    }

    @GetMapping("/{id}/detailBook")
    public String goDetail(@PathVariable Integer id, Model model) {
        model.addAttribute("book", iBookService.findById(id));
        return "/detail";
    }

    @GetMapping("/{id}/lendBook")
    public String doLendForm(@PathVariable String id, RedirectAttributes redirectAttributes) throws RunoutQuantity {
        String message = null;
        Integer bookId = Integer.parseInt(id);
        Boolean check = iBookService.lendBookById(bookId);
        if (check) {
            Long lendCode = Math.round(Math.random() * 89999 + 10000);
            Book book = iBookService.findById(bookId);
            BookLendVoucher bookLendVoucher = new BookLendVoucher();
            bookLendVoucher.setLendCode(lendCode);
            bookLendVoucher.setBook(book);
            iBookLendVoucherService.save(bookLendVoucher);
            message = "bạn đã mượn thành công!";
        } else {
            message = "đầu sách này đã được mượn hết";
        }
        redirectAttributes.addFlashAttribute("message", message);
        return "redirect:/home";
    }

    @GetMapping("/listBookBorrowed")
    public String goBookBorrowedList(Model model) {
        model.addAttribute("bookBorrowedList", iBookLendVoucherService.findAll());
        return "listBorrow";
    }

    @PostMapping("/payBook")
    public String doPayBookForm(@RequestParam String lendingCode, RedirectAttributes redirectAttributes) {
        Long lendCode = Long.parseLong(lendingCode);
        String message = null;
        BookLendVoucher bookLendVoucher = iBookLendVoucherService.findByLendCode(lendCode);
        if (bookLendVoucher != null) {
            iBookService.payBook(bookLendVoucher.getBook());
            iBookLendVoucherService.delete(bookLendVoucher);
            message = "bạn đã trả sách";
        } else {
            message = "mã trả sách không đúng, hãy thử lại";
        }
        redirectAttributes.addFlashAttribute("message", message);
        System.out.println(message);
        return "redirect:/home";
    }
    @ExceptionHandler(RunoutQuantity.class)
    public String showError() { return "error";}

    @ExceptionHandler(NumberFormatException.class)
    public String showErrorPage() { return "error";}



}
