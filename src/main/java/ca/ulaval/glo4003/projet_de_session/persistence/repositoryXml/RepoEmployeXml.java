package ca.ulaval.glo4003.projet_de_session.persistence.repositoryXml;

import ca.ulaval.glo4003.projet_de_session.core.domain.Employe;

public class RepoEmployeXml extends RepoGeneralXml<Employe> {
	
	public RepoEmployeXml()
	{
		super(Employe.class,"employes");
	}
	
	public String ajouter(Employe e)
	{
		if (obt( e.obtNomUtilisateur() ) == null)
		{
			put(e.obtNomUtilisateur(), e);
		}
		
		return e.obtNomUtilisateur();
	}

	public void modifier(Employe employe)
	{
		if(obt( employe.obtNomUtilisateur() ) != null)
		{
			put(employe.obtNomUtilisateur(), employe);
		}
	}
}
