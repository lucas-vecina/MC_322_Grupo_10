/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;

/**
 *
 * @author USER
 */
public class Excecao extends IllegalArgumentException{

    public Excecao() {
        super("Argumento errado");
    }

    public Excecao(String s) {
        super(s);
    }

    public Excecao(String message, Throwable cause) {
        super(message, cause);
    }

    public Excecao(Throwable cause) {
        super(cause);
    }
}
