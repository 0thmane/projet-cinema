package fr.spring.cinema.web;

import fr.spring.cinema.Form.TicketForm;
import fr.spring.cinema.dao.FilmRepository;
import fr.spring.cinema.dao.TicketRepository;
import fr.spring.cinema.entity.Film;
import fr.spring.cinema.entity.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CinemaRestController {
    @Autowired
    FilmRepository filmRepository;
    @Autowired
    TicketRepository ticketRepository ;
    @GetMapping(path = "/images/{id}",produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] images(@PathVariable("id") Long id) throws IOException {
        Film film = filmRepository.findById(id).get() ;
        String photoName = film.getPhoto();
        File file = new File(System.getProperty("user.home")+"/Bureau/git/projet-cinema/images/"+photoName);
        Path path = Paths.get(file.toURI());
        return Files.readAllBytes(path);

    }

    @PostMapping(value = "/payerTickets")
    @Transactional
    public List<Ticket> payerTicket(@RequestBody TicketForm ticketForm){
        List<Ticket> ticketList = new ArrayList<>();
        ticketForm.getListTicketId().forEach(id ->{
        Ticket ticket = ticketRepository.findById(id).get();
        ticket.setReserve(true);
        ticket.setNomClient(ticketForm.getNameClient());
        ticket.setCodePayement(ticketForm.getCodepayement());
        ticketRepository.save(ticket);
        ticketList.add(ticket);
        });
        return ticketList;
    }

}
