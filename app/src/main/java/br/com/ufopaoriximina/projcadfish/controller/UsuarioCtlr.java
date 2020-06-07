package br.com.ufopaoriximina.projcadfish.controller;

import java.util.List;

import br.com.ufopaoriximina.projcadfish.dao.DataSource;
import br.com.ufopaoriximina.projcadfish.dao.ParticipanteDAO;
import br.com.ufopaoriximina.projcadfish.model.Usuario;

public class UsuarioCtlr {

    private final ParticipanteDAO participanteDAO;

    public UsuarioCtlr(DataSource pDataSource){
        participanteDAO = new ParticipanteDAO(pDataSource);
    }

    public long salvarUsuarioCtrl(Usuario pUsuario){
      return this.participanteDAO.salvarParticipanteDAO(pUsuario);
    }

    public List<Usuario> getListaUsuarioCtrl(){
       return this.participanteDAO.getListaParticipanteDAO();
    }
}