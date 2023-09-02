package com.example.demo.controlloer;

import com.example.demo.entity.Board;
import com.example.demo.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;
    @GetMapping("/board/write") // localhost:8080/board/wirte
    public String boardWriteForm(){
        return "boardWrite";
    }

    @PostMapping("/board/writePro") // DB에 저장하기위해서 repository 필요
    public String boardWritePro(Board board){

        boardService.write(board);

        return "redirect:/board/list";
    }

    @GetMapping("/board/list")
    public String boardList(Model model){

        model.addAttribute("list", boardService.boardList());

        return "boardList";
    }

    @GetMapping("/board/view") //localhost:8080/board/view?id=1
    public String boardView(Model model, Integer id){

        model.addAttribute("board", boardService.boardView(id));
        return "boardView";
    }

    @GetMapping("/board/delete")
    public String boardDelete(Integer id){

        boardService.boardDelete(id);
        return "redirect:/board/list";
    }

    @GetMapping("/board/update/{id}")
    public String boardUpdate(Model model, @PathVariable("id") Integer id){

        model.addAttribute("board", boardService.boardView(id));
        return "boardUpdate";
    }


    @PostMapping("/board/updatePro/{id}")
    public String boardUpdatePro(@PathVariable("id") Integer id, Board board){

        Board boardTemp = boardService.boardView(id);
        boardTemp.setTitle(board.getTitle());
        boardTemp.setContent(board.getContent());

        boardService.write(board);

        return "redirect:/board/list";
    }
}
