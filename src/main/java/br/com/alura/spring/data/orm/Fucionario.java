package br.com.alura.spring.data.orm;

import javax.persistence.*;

@Entity
@Table(name = "funcionarios")
public class Fucionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String funcaoDoTrabalho;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFuncaoDoTrabalho() {
        return funcaoDoTrabalho;
    }

    public void setFuncaoDoTrabalho(String funcaoDoTrabalho) {
        this.funcaoDoTrabalho = funcaoDoTrabalho;
    }

    @Override
    public String toString(){
        return "Id: " + id + "Função: " + funcaoDoTrabalho;
    }
}
