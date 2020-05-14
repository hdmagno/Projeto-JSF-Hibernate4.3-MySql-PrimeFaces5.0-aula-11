package manager;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import entity.Aluno;
import persistence.AlunoDao;

@RequestScoped
@ManagedBean(name = "mb")
public class ManagerBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private Aluno aluno;
	private List<Aluno> alunos;

	public ManagerBean() {
		this.aluno = new Aluno();
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public List<Aluno> getAlunos() {
		try {
			this.alunos = new AlunoDao().findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public void calcular() {
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			this.aluno.setMedia((this.aluno.getNota1() + this.aluno.getNota2()) / 2);
			fc.addMessage(null, new FacesMessage("Média Gerada..."));
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage("Error: " + e.getMessage()));
		}
	}

	public void cadastrar() {
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			calcular();
			new AlunoDao().create(this.aluno);
			fc.addMessage(null, new FacesMessage("Dados Gravados..."));
			this.aluno = new Aluno();
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage("Error: " + e.getMessage()));
		}
	}
}
