package ca.ulaval.glo4003.projet_de_session.persistence.repositoryXml;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import ca.ulaval.glo4003.projet_de_session.core.domain.DepenseDeplacement;
import ca.ulaval.glo4003.projet_de_session.persistence.utils.Xml;

public class RepoDepenseDeplacementXmlTest {

	private static DepenseDeplacement DepenseDeplacement1;
	private static DepenseDeplacement DepenseDeplacement2;
	private static Xml<DepenseDeplacement> xmlDepenseDeplacement;
	private static ArrayList<DepenseDeplacement> sauvegardeCollection;
	private static RepoDepenseDeplacementXml repoDepenseDeplacementXml;
	private static final float un = (float) 15.0;
	private static final float deux = (float) 16.8;
	private static final float trois = (float) 20.9;
	private static final Integer quatre = (Integer) 3;
	private static final float cinq = (float) 20.0;
	private static final float six = (float) 22.8;
	private static final float sept = (float) 234.9;
	private static final Integer huit = (Integer) 4;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		xmlDepenseDeplacement = new Xml<DepenseDeplacement>(DepenseDeplacement.class);
		
		sauvegardeCollection = (ArrayList<DepenseDeplacement>) xmlDepenseDeplacement
				.charger("xmlfiles/depensesDeplacement");

		repoDepenseDeplacementXml = new RepoDepenseDeplacementXml();
		DepenseDeplacement1 = Mockito.mock(DepenseDeplacement.class);
		Mockito.when(DepenseDeplacement1.obtCoutKm()).thenReturn(un);
		Mockito.when(DepenseDeplacement1.obtDistance()).thenReturn(deux);
		Mockito.when(DepenseDeplacement1.obtDate()).thenReturn("2010-11-14");
		Mockito.when(DepenseDeplacement1.obtDescription()).thenReturn("test");
		Mockito.when(DepenseDeplacement1.obtIdentifiant()).thenReturn("ALSAM");
		Mockito.when(DepenseDeplacement1.obtTime()).thenReturn("123");
		
		repoDepenseDeplacementXml = new RepoDepenseDeplacementXml();
		DepenseDeplacement2 = Mockito.mock(DepenseDeplacement.class);
		Mockito.when(DepenseDeplacement1.obtCoutKm()).thenReturn(cinq);
		Mockito.when(DepenseDeplacement1.obtDistance()).thenReturn(six);
		Mockito.when(DepenseDeplacement2.obtDate()).thenReturn("2010-11-14");
		Mockito.when(DepenseDeplacement2.obtDescription()).thenReturn("descirption");
		Mockito.when(DepenseDeplacement2.obtIdentifiant()).thenReturn("ALSAM");
		Mockito.when(DepenseDeplacement2.obtTime()).thenReturn("123");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		xmlDepenseDeplacement.enregistrer(sauvegardeCollection,
				"xmlfiles/depensesDeplacement");
	}
	@Before
	public void setUp() throws Exception {
		xmlDepenseDeplacement.enregistrer(new ArrayList<DepenseDeplacement>(),
				"xmlfiles/depensesDeplacement");
		repoDepenseDeplacementXml = new RepoDepenseDeplacementXml();
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void AjouterDepenseDeplacementTest() {
		String id = DepenseDeplacement1.obtIdentifiant()
				+ DepenseDeplacement1.obtDate() + DepenseDeplacement1.obtTime();
		repoDepenseDeplacementXml.ajouter(DepenseDeplacement1);
		assertEquals(repoDepenseDeplacementXml.obt(id), DepenseDeplacement1);
	}
	
	@Test
	public void ModifierDepenseDeplacementTest() {
		repoDepenseDeplacementXml.ajouter(DepenseDeplacement1);
		String id = DepenseDeplacement2.obtIdentifiant()
				+ DepenseDeplacement2.obtDate() + DepenseDeplacement2.obtTime();
		repoDepenseDeplacementXml.modifier(DepenseDeplacement2);
		assertEquals(DepenseDeplacement2, repoDepenseDeplacementXml.obt(id));
	}
	
	@Test
	public void ObtTest() {
		String id = DepenseDeplacement1.obtIdentifiant()
				+ DepenseDeplacement1.obtDate() + DepenseDeplacement1.obtTime();
		repoDepenseDeplacementXml.ajouter(DepenseDeplacement1);
		assertEquals(DepenseDeplacement1, repoDepenseDeplacementXml.obt(id));
	}
}