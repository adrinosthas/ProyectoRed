/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

/**
 *
 * @author Adri
 */
public class FOTO {
    int idFoto;
    int idAlbum;
    int idUsuario;
    String urlFoto;
    String fechaPublicada;
    boolean FotoPerfil;

    public int getIdFoto() {
        return idFoto;
    }

    public void setIdFoto(int idFoto) {
        this.idFoto = idFoto;
    }

    public int getIdAlbum() {
        return idAlbum;
    }

    public void setIdAlbum(int idAlbum) {
        this.idAlbum = idAlbum;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }


    public String getFechaPublicada() {
        return fechaPublicada;
    }

    public void setFechaPublicada(String fechaPublicada) {
        this.fechaPublicada = fechaPublicada;
    }

    public boolean isFotoPerfil() {
        return FotoPerfil;
    }

    public void setFotoPerfil(boolean FotoPerfil) {
        this.FotoPerfil = FotoPerfil;
    }
}
