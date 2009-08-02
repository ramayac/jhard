/*
 * jmlIniciaClase.java
 *
 * Created on 08-02-2009, 03:07:30 PM
 * Copyright rodrigo
 */
package jhard;

import edu.ues.jhard.beans.BeanBaseManLab;
import edu.ues.jhard.jpa.Clase;
import edu.ues.jhard.jpa.Curso;
import edu.ues.jhard.jpa.Horario;
import java.util.ArrayList;
import java.util.List;


public class jmlIniciaClase extends BeanBaseJHard {

    private BeanBaseManLab jmanLabInstance = new BeanBaseManLab();

    private List<Curso> listaCursos = new ArrayList<Curso>();
    private List<Horario> listaHorario = new ArrayList<Horario>();
    private Clase nuevaClase = new Clase();

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public jmlIniciaClase() {
    }


}

