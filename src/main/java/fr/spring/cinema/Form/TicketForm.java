package fr.spring.cinema.Form;

import fr.spring.cinema.entity.Ticket;

import java.util.ArrayList;
import java.util.List;

public class TicketForm {

    private String nameClient ;
    private List<Long> listTicketId = new ArrayList<Long>();
    private Integer codepayement ;

    public TicketForm() {
    }

    public String getNameClient() {
        return nameClient;
    }

    public void setNameClient(String nameClient) {
        this.nameClient = nameClient;
    }

    public List<Long> getListTicketId() {
        return listTicketId;
    }

    public void setListTicketId(List<Long> listTicketId) {
        this.listTicketId = listTicketId;
    }

    public Integer getCodepayement() {
        return codepayement;
    }

    public void setCodepayement(Integer codepayement) {
        this.codepayement = codepayement;
    }
}
