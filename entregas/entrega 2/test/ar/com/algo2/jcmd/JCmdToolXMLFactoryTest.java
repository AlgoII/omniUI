package ar.com.algo2.jcmd;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import ar.com.algo2.jcmd.appmodel.JCmdToolXMLFactory;
import ar.com.algo2.jcmd.dominio.ArgumentoBoolean;
import ar.com.algo2.jcmd.dominio.ArgumentoComboBox;
import ar.com.algo2.jcmd.dominio.ArgumentoNumerico;
import ar.com.algo2.jcmd.dominio.Lanzador;
import ar.com.algo2.jcmd.parsers.JCmdToolSAXParser;
import ar.com.algo2.jcmd.parsers.JCmdToolXStreamParser;

public class JCmdToolXMLFactoryTest extends TestCase {

	private JCmdToolXMLFactory xmlFactory; 

	@Before
	public void setUp() 
	{
		xmlFactory = JCmdToolXMLFactory.getInstance();
	}

	@Test
	public void testGetLanzadorFromXmlXStreamParser() {

		xmlFactory.init(new JCmdToolXStreamParser());

		Lanzador lanzador = xmlFactory.getLanzadorFromXml("test.xml");	

		assertNotNull(lanzador);		
	}

	@Test
	public void testGetLanzadorFromXmlSaxParser() {

		xmlFactory.init(new JCmdToolSAXParser());

		Lanzador lanzador = xmlFactory.getLanzadorFromXml("test.xml");
		
		assertNotNull(lanzador);

	}


	@Test
	public void testComandosFromXStreamParser() {

		xmlFactory.init(new JCmdToolXStreamParser());

		Lanzador lanzador = xmlFactory.getLanzadorFromXml("test.xml");

		evalComandos(lanzador);

	}

	@Test
	public void testAplicacionesFromXStreamParser() {

		xmlFactory.init(new JCmdToolXStreamParser());

		Lanzador lanzador = xmlFactory.getLanzadorFromXml("test.xml");

		evalAplicaciones(lanzador);

	}
	
	@Test
	public void testArgumentosFromXStreamParser() {

		xmlFactory.init(new JCmdToolXStreamParser());

		Lanzador lanzador = xmlFactory.getLanzadorFromXml("test.xml");
		
		evalArgumentos(lanzador);
		
	}		

	public void testValidacionesFromXStreamParser() {

		xmlFactory.init(new JCmdToolXStreamParser());

		Lanzador lanzador = xmlFactory.getLanzadorFromXml("test.xml");
		
		evalValidaciones(lanzador);

	}
	
	@Test
	public void testComandosFromSaxParser() {

		xmlFactory.init(new JCmdToolSAXParser());

		Lanzador lanzador = xmlFactory.getLanzadorFromXml("test.xml");

		evalComandos(lanzador);

	}

	@Test
	public void testAplicacionesFromSaxParser() {

		xmlFactory.init(new JCmdToolSAXParser());

		Lanzador lanzador = xmlFactory.getLanzadorFromXml("test.xml");

		evalAplicaciones(lanzador);

	}
	
	@Test
	public void testArgumentosFromSaxParser() {

		xmlFactory.init(new JCmdToolSAXParser());

		Lanzador lanzador = xmlFactory.getLanzadorFromXml("test.xml");
		
		evalArgumentos(lanzador);
		
	}		
	
	private static void evalComandos(Lanzador lanzador) {

		assertEquals(2, lanzador.getComandos().size());	

		assertEquals("git", lanzador.getComandos().get(0).getNombre());	
		assertEquals("Git", lanzador.getComandos().get(0).getAlias());
		assertEquals("cliente de Git", lanzador.getComandos().get(0).getDescripcion());
		assertEquals("./input/archivo.txt", lanzador.getComandos().get(0).getOutput());	

		assertEquals(1, lanzador.getComandos().get(0).getAplicaciones().size());
		assertEquals(2, lanzador.getComandos().get(0).getAplicaciones().get(0).getValidaciones().size());

		assertEquals("echo", lanzador.getComandos().get(1).getNombre());	
		assertNull(lanzador.getComandos().get(1).getAlias());
		assertNull(lanzador.getComandos().get(1).getDescripcion());
		assertNull(lanzador.getComandos().get(1).getOutput());

		assertEquals(1, lanzador.getComandos().get(1).getAplicaciones().size());		
	}

	private static void evalAplicaciones(Lanzador lanzador) {

		assertEquals("commit", lanzador.getComandos().get(0).getAplicaciones().get(0).getNombre());
		assertEquals("actualiza indice en el repositorio local", lanzador.getComandos().get(0).getAplicaciones().get(0).getDescripcion());

		assertEquals(10, lanzador.getComandos().get(0).getAplicaciones().get(0).getArgumentos().size());
		assertEquals(1, lanzador.getComandos().get(1).getAplicaciones().get(0).getArgumentos().size());

		assertNull(lanzador.getComandos().get(1).getAplicaciones().get(0).getNombre());
		assertNull(lanzador.getComandos().get(1).getAplicaciones().get(0).getDescripcion());

	}
	
	private static void evalArgumentos(Lanzador lanzador) {
		
		assertEquals(new Long(1),lanzador.getComandos().get(0).getAplicaciones().get(0).getArgumentos().get(0).getOrden());
		assertEquals(new Long(2),lanzador.getComandos().get(0).getAplicaciones().get(0).getArgumentos().get(1).getOrden());
		assertEquals(new Long(3),lanzador.getComandos().get(0).getAplicaciones().get(0).getArgumentos().get(2).getOrden());
		assertEquals(new Long(4),lanzador.getComandos().get(0).getAplicaciones().get(0).getArgumentos().get(3).getOrden());
		assertEquals(new Long(5),lanzador.getComandos().get(0).getAplicaciones().get(0).getArgumentos().get(4).getOrden());
		assertEquals(new Long(6),lanzador.getComandos().get(0).getAplicaciones().get(0).getArgumentos().get(5).getOrden());
		assertEquals(new Long(7),lanzador.getComandos().get(0).getAplicaciones().get(0).getArgumentos().get(6).getOrden());
		assertEquals(new Long(8),lanzador.getComandos().get(0).getAplicaciones().get(0).getArgumentos().get(7).getOrden());
		assertEquals(new Long(9),lanzador.getComandos().get(0).getAplicaciones().get(0).getArgumentos().get(8).getOrden());
		assertNull(lanzador.getComandos().get(0).getAplicaciones().get(0).getArgumentos().				get(9).getOrden());
		assertNull(lanzador.getComandos().get(1).getAplicaciones().get(0).getArgumentos().				get(0).getOrden());

		assertEquals("Boolean" ,lanzador.getComandos().get(0).getAplicaciones().get(0).getArgumentos().	get(0).getTipo());
		assertEquals("Search" 	,lanzador.getComandos().get(0).getAplicaciones().get(0).getArgumentos().get(1).getTipo());
		assertEquals("Text" 	,lanzador.getComandos().get(0).getAplicaciones().get(0).getArgumentos().get(2).getTipo());
		assertEquals("Search" 	,lanzador.getComandos().get(0).getAplicaciones().get(0).getArgumentos().get(3).getTipo());
		assertEquals("Text" 	,lanzador.getComandos().get(0).getAplicaciones().get(0).getArgumentos().get(4).getTipo());
		assertEquals("ComboBox",lanzador.getComandos().get(0).getAplicaciones().get(0).getArgumentos().	get(5).getTipo());
		assertEquals("Boolean" ,lanzador.getComandos().get(0).getAplicaciones().get(0).getArgumentos().	get(6).getTipo());
		assertEquals("Number" 	,lanzador.getComandos().get(0).getAplicaciones().get(0).getArgumentos().get(7).getTipo());
		assertEquals("Date" 	,lanzador.getComandos().get(0).getAplicaciones().get(0).getArgumentos().get(8).getTipo());
		assertNull(lanzador.getComandos().get(0).getAplicaciones().get(0).getArgumentos().				get(9).getTipo());
		assertNull(lanzador.getComandos().get(1).getAplicaciones().get(0).getArgumentos().				get(0).getTipo());

		assertEquals("--verbose" 		,lanzador.getComandos().get(0).getAplicaciones().get(0).getArgumentos()	.	get(0).getAlternativo());
		assertNull(lanzador.getComandos().get(0).getAplicaciones().get(0).getArgumentos().						 	get(1).getAlternativo());
		assertEquals("--message" 		,lanzador.getComandos().get(0).getAplicaciones().get(0).getArgumentos()	.	get(2).getAlternativo());
		assertEquals("--file" 			,lanzador.getComandos().get(0).getAplicaciones().get(0).getArgumentos()	.	get(3).getAlternativo());
		assertEquals("--gpg-sign" 		,lanzador.getComandos().get(0).getAplicaciones().get(0).getArgumentos()	.	get(4).getAlternativo());
		assertEquals("--untracked-files" ,lanzador.getComandos().get(0).getAplicaciones().get(0).getArgumentos().	get(5).getAlternativo());
		assertNull(lanzador.getComandos().get(0).getAplicaciones().get(0).getArgumentos().							get(6).getAlternativo());
		assertEquals("--mainline" 		,lanzador.getComandos().get(0).getAplicaciones().get(0).getArgumentos().	get(7).getAlternativo());
		assertNull(lanzador.getComandos().get(0).getAplicaciones().get(0).getArgumentos().							get(8).getAlternativo());
		assertNull(lanzador.getComandos().get(0).getAplicaciones().get(0).getArgumentos().							get(9).getAlternativo());

		assertEquals("muestra lo comitteado" ,lanzador.getComandos().get(0).getAplicaciones().get(0).getArgumentos().					get(0).getDescripcion());
		assertNull(lanzador.getComandos().get(0).getAplicaciones().get(0).getArgumentos().												get(1). getDescripcion());
		assertEquals("mensaje del commit" ,lanzador.getComandos().get(0).getAplicaciones().get(0).getArgumentos().						get(2).getDescripcion());
		assertEquals("lee mensaje de archivo" ,lanzador.getComandos().get(0).getAplicaciones().get(0).getArgumentos().					get(3). getDescripcion());
		assertEquals("firma GPG" ,lanzador.getComandos().get(0).getAplicaciones().get(0).getArgumentos().								get(4). getDescripcion());
		assertEquals("firma GPG" ,lanzador.getComandos().get(0).getAplicaciones().get(0).getArgumentos().								get(5).getDescripcion());
		assertEquals("incluye status en el mensaje del commit" ,lanzador.getComandos().get(0).getAplicaciones().get(0).getArgumentos().	get(6).getDescripcion());
		assertEquals("numero padre" ,lanzador.getComandos().get(0).getAplicaciones().get(0).getArgumentos().							get(7).getDescripcion());
		assertEquals("sobreescribe la fecha del commit" ,lanzador.getComandos().get(0).getAplicaciones().get(0).getArgumentos().		get(8). getDescripcion());
		assertNull(lanzador.getComandos().get(0).getAplicaciones().get(0).getArgumentos().												get(9).getDescripcion());

		assertEquals(new Boolean(true ),lanzador.getComandos().get(0).getAplicaciones().get(0).getArgumentos().get(0).getHabilitado());
		assertEquals(new Boolean(false),lanzador.getComandos().get(0).getAplicaciones().get(0).getArgumentos().get(1).getHabilitado());
		assertEquals(new Boolean(true ),lanzador.getComandos().get(0).getAplicaciones().get(0).getArgumentos().get(2).getHabilitado());
		assertEquals(new Boolean(true ),lanzador.getComandos().get(0).getAplicaciones().get(0).getArgumentos().get(3).getHabilitado());
		assertEquals(new Boolean(true ),lanzador.getComandos().get(0).getAplicaciones().get(0).getArgumentos().get(4).getHabilitado());
		assertEquals(new Boolean(true ),lanzador.getComandos().get(0).getAplicaciones().get(0).getArgumentos().get(5).getHabilitado());
		assertEquals(new Boolean(true ),lanzador.getComandos().get(0).getAplicaciones().get(0).getArgumentos().get(6).getHabilitado());
		assertEquals(new Boolean(true ),lanzador.getComandos().get(0).getAplicaciones().get(0).getArgumentos().get(7).getHabilitado());
		assertEquals(new Boolean(true ),lanzador.getComandos().get(0).getAplicaciones().get(0).getArgumentos().get(8).getHabilitado());

		assertEquals( new Boolean(true	) ,lanzador.getComandos().get(0).getAplicaciones().get(0).getArgumentos().	get(0 ).getOptional());
		assertEquals( new Boolean(true	) ,lanzador.getComandos().get(0).getAplicaciones().get(0).getArgumentos().	get(1 ).getOptional());
		assertEquals( new Boolean(false) ,lanzador.getComandos().get(0).getAplicaciones().get(0).getArgumentos().	get(2 ).getOptional());
		assertEquals( new Boolean(true) ,lanzador.getComandos().get(0).getAplicaciones().get(0).getArgumentos().	get(3 ).getOptional());
		assertEquals( new Boolean(true ) ,lanzador.getComandos().get(0).getAplicaciones().get(0).getArgumentos().	get(4 ).getOptional());
		assertEquals( new Boolean(true ) ,lanzador.getComandos().get(0).getAplicaciones().get(0).getArgumentos().	get(5 ).getOptional());
		assertEquals( new Boolean(true ) ,lanzador.getComandos().get(0).getAplicaciones().get(0).getArgumentos().	get(6 ).getOptional());
		assertEquals( new Boolean(true ) ,lanzador.getComandos().get(0).getAplicaciones().get(0).getArgumentos().	get(7 ).getOptional());
		assertEquals( new Boolean(true) ,lanzador.getComandos().get(0).getAplicaciones().get(0).getArgumentos().	get(8 ).getOptional());

		assertEquals( new Boolean(true)	,((ArgumentoBoolean) lanzador.getComandos().get(0).getAplicaciones().get(0).getArgumentos().get(0)).getValorInicial());
		assertEquals( "=" ,lanzador.getComandos().get(0).getAplicaciones().get(0).getArgumentos().get(4).getSeparador());
		assertEquals( "=" ,lanzador.getComandos().get(0).getAplicaciones().get(0).getArgumentos().get(5).getSeparador());
		assertEquals( new Boolean(false)	,((ArgumentoBoolean) lanzador.getComandos().get(0).getAplicaciones().get(0).getArgumentos().get(6)).getValorInicial());
		assertEquals( "#" ,((ArgumentoNumerico)lanzador.getComandos().get(0).getAplicaciones().get(0).getArgumentos().get(7)).getMask());

		assertEquals("Verboso",lanzador.getComandos().get(0).getAplicaciones().get(0).getArgumentos().get(0)					 .getEtiqueta());
		assertEquals("Mensaje para el log", lanzador.getComandos().get(0).getAplicaciones().get(0).getArgumentos().get(2)        .getEtiqueta());
		assertEquals("Archivo origen del mensaje", lanzador.getComandos().get(0).getAplicaciones().get(0).getArgumentos().get(3) .getEtiqueta());
		assertEquals("Key ID", lanzador.getComandos().get(0).getAplicaciones().get(0).getArgumentos().get(4)                     .getEtiqueta());
		assertEquals("Modo", lanzador.getComandos().get(0).getAplicaciones().get(0).getArgumentos().get(5)                       .getEtiqueta());
		assertEquals("Version", lanzador.getComandos().get(0).getAplicaciones().get(0).getArgumentos().get(7)                    .getEtiqueta());
		assertEquals("Fecha del commit", lanzador.getComandos().get(0).getAplicaciones().get(0).getArgumentos().get(8)           .getEtiqueta());
		assertEquals("Nombre(s) de archivo(s)", lanzador.getComandos().get(0).getAplicaciones().get(0).getArgumentos().get(9)    .getEtiqueta());

		assertEquals("Mensaje", lanzador.getComandos().get(1).getAplicaciones().get(0).getArgumentos().get(0)           .getEtiqueta());

		assertEquals(1, lanzador.getComandos().get(0).getAplicaciones().get(0).getArgumentos().get(2).getReglas().size());
		assertEquals(2, lanzador.getComandos().get(0).getAplicaciones().get(0).getArgumentos().get(7).getReglas().size());


		assertEquals(3, ((ArgumentoComboBox) lanzador.getComandos().get(0).getAplicaciones().get(0).getArgumentos().get(5)).getValores().size());

		assertEquals("all", ((ArgumentoComboBox) lanzador.getComandos().get(0).getAplicaciones().get(0).getArgumentos().get(5)).getValores().get(0));
		assertEquals("normal", ((ArgumentoComboBox) lanzador.getComandos().get(0).getAplicaciones().get(0).getArgumentos().get(5)).getValores().get(1));
		assertEquals("no", ((ArgumentoComboBox) lanzador.getComandos().get(0).getAplicaciones().get(0).getArgumentos().get(5)).getValores().get(2));
		
	}
	
	private static void evalValidaciones(Lanzador lanzador) {
				
		assertEquals(2,lanzador.getComandos().get(0).getAplicaciones().get(0).getValidaciones().size());

		assertEquals("habilitarCampoSiCheckboxEstaEnTrue",lanzador.getComandos().get(0).getAplicaciones().get(0).getValidaciones().get(0).getAccion().getNombre());
		assertEquals("-v",lanzador.getComandos().get(0).getAplicaciones().get(0).getValidaciones().get(0).getAccion().getParametros().get(0).getValor());
		assertEquals("pathVerbose",lanzador.getComandos().get(0).getAplicaciones().get(0).getValidaciones().get(0).getAccion().getParametros().get(1).getValor());

		assertEquals("mostrarFechaEnFormatoLatino",lanzador.getComandos().get(0).getAplicaciones().get(0).getValidaciones().get(1).getAccion().getNombre());		
		assertEquals("La fecha de hoy es: "	,lanzador.getComandos().get(0).getAplicaciones().get(0).getValidaciones().get(1).getAccion().getParametros().get(0).getValor());
		assertEquals("--date",lanzador.getComandos().get(0).getAplicaciones().get(0).getValidaciones().get(1).getAccion().getParametros().get(1).getValor());
		
	}



}

