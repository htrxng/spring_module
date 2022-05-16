package com.codegym.controller;

import com.codegym.model.Book;
import com.codegym.model.BookLendVoucher;
import com.codegym.service.IBookLendVoucherService;
import com.codegym.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BookController {
    @Autowired
    private IBookService iBookService;
    @Autowired
    IBookLendVoucherService iBookLendVoucherService;

    @GetMapping("/home")
    public String goHome(Model model){
        model.addAttribute("bookList",iBookService.findAll());
        return "list";
    }

    @GetMapping(value = "/add")
    public String goAddBook(Model model) {
        model.addAttribute("book",new Book());
        return "/create";
    }
    @PostMapping(value = "/addNewBook")
    public String addNewBook(Book book) {
        iBookService.save(book);
        return "redirect:/home";
    }
    @GetMapping("/{id}/detailBook")
    public String goDetail(@PathVariable Integer id,Model model) {
        model.addAttribute("book",iBookService.findById(id));
        return "/detail";
    }
    @GetMapping("/{id}/lendBook")
    public String goLendForm(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        String notice = iBookService.lendBookById(id);
        System.out.println(notice);
        redirectAttributes.addFlashAttribute(notice);
        return "redirect:/home";
    }
    @GetMapping("/listBookBorrowed")
    public String goBookBorrowedList(Model model){
        model.addAttribute("bookBorrowedList",iBookLendVoucherService.findAll());
        return "listBorrow";
    }
    @PostMapping("/payBook")
    public String goPayBookForm(@RequestParam String codeLending,RedirectAttributes redirectAttributes) {
       String notice = iBookLendVoucherService.findByCodeLending( Long.parseLong(codeLending));
       redirectAttributes.addFlashAttribute(notice);
        System.out.println(notice);
    return "redirect:/home";
    }

}
