package model;

import android.graphics.Bitmap;
import android.media.Image;
import android.widget.ImageView;

public class matriculaModel {
    public String matricula;
    public String nome;
    public String email;
    public String estado;
    public String cidade;
    public Bitmap foto;

    public matriculaModel(String m, String n, String e, String est, String cid, Bitmap imagem){
        matricula = m;
        nome =  n;
        email = e;
        estado = est;
        cidade = cid;
        foto = imagem;
    }
}
