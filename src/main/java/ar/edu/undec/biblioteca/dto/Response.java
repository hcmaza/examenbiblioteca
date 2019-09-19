package ar.edu.undec.biblioteca.dto;

public class Response {

    private int estado;
    private String messaje;
    private Object data;

    public Response() {
        this.estado = 0;
        this.messaje = "";
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getMessaje() {
        return messaje;
    }

    public void setMessaje(String messaje) {
        this.messaje = messaje;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
