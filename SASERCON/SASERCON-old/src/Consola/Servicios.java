
package Consola;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Servicios {

    ALERTA al = new ALERTA();
    ArrayList<Integer> encontrados = new ArrayList<Integer>();

    protected ArrayList<String> Scliente = new ArrayList<String>()  {{
        add("Plaza Madero");
    }},Sdescripcion = new ArrayList<String>()  {{
        add("SERVICIO DE MANTENIMIENTO CORRESPONDIENTE AL MES DE ABRIL DEL 2018 PARA UN (1) ELEVADOR DE PASAJEROS UBICADO EN: MADERO N� 70, COL. CENTRO, CIUDAD DE MeXICO");
    }},Slugar = new ArrayList<String>()  {{
        add("MADERO No 70, COL. CENTRO, CIUDAD DE MeXICO");
    }},Sfolio = new ArrayList<String>()  {{
        add("6895RDB");
    }};
    public ArrayList<String> Scategoria = new ArrayList<String>()  {{
        add("frenos");
    }};
    protected ArrayList<Float> Scosto = new ArrayList<Float>()  {{
        add(1624.00f);
    }};
    protected ArrayList<String> Sduracion = new ArrayList<String>()  {{
        add("29/11/2018");
    }};
    public ArrayList<String> Sobservaciones = new ArrayList<String>()  {{
        add("Ninguna");
    }};

    public ArrayList<String> SstatusPago = new ArrayList<String>()   {{
        add("Realizado");
    }}, Simportancia = new ArrayList<String>()   {{
        add("Alta");
    }}, Stipo = new ArrayList<String>() {{
        add("Preventivo");
    }}, Sstatus = new ArrayList<String>()   {{
        add("Programado");
    }};

    boolean rep=true,seguir=true;
    Scanner entrada = new Scanner(System.in);
    int opc;
    String Sserv;
   
    /*
     *Smenu method, show the service menu and it show the options to insert or search a service
     *Doesn't use parameters
     *Use globals variables: Boolean rep, Integer opc
     *Doesn't return anything
     * */
    public void Smenu() {
        do {
            System.out.println("\n\t  MENU");
            System.out.println("\t1.-Ingresar");
            System.out.println("\t2.-Buscar");
            System.out.println("\t3.-Regresar");
            opc = al.valint("Su opcion: ");
            switch(opc) {
                case 1:
                    SIngresar();
                    rep=false;
                    break;
                case 2:
                    BServicio();
                    rep=false;
                    break;
                case 3:
                    System.out.println("Regresando al Menu Principal");
                    rep=false;
                    break;
                default:
                    System.out.println("\n\tOpcion incorrecta:");
                    rep=true;
                    break;
            }
        } while(rep == true);
    }
    /* SIngresar method, saves in the local program a service data
     * Doesn't use parameters
     * 
     * Doesn't return anything
     * */
    public void SIngresar() {
        char o;
        //Ccliente cc = new Ccliente();   // Instance the Ccliente class by realization
        Agenda Sf=new Agenda(); // Instance Sfecha class to return a duration time to "Sduracion"
        ALERTA al = new ALERTA();   // Instance ALERTA class to validate: Text, Integers and Charmanders
                
        // Calls the information and save the client info
        /*do {
            //cc.MCliente();
            System.out.println("Escoja el cliente para realizar servicio");
            String SCliente=cc.UsarFolio(entrada.next());
            if(!SCliente.equals("ERROR"))   {
                System.out.println("El folio que ingreso no existe.");
                rep=true;
            }
            else    {
                Scliente.add(SCliente);
                rep=false;
            }
        } while (rep==true);
        */

        System.out.println("\n\tSeleccione las categorias del servicio.");
        System.out.println("A.-ubicacion de la maquina");
        System.out.println("B.-niveles de aceite");
        System.out.println("C.-freno de la maquina o motor");
        System.out.println("D.-rieles");
        System.out.println("E.-funcionamiento de control");
        System.out.println("F.-regulador final de parada");
        System.out.println("G.-senhalizaciones");
        System.out.println("H.-operador de puertas");
        System.out.println("I.-seguridades");
        System.out.println("J.-funcionamiento de puertas de cabina");
        System.out.println("K.-alarma");
        System.out.println("L.-funcionamiento de puertas de pasillo");
        System.out.println("M.-fosa");
        System.out.println("N.-cables de traccion");
        System.out.println("O.-botoneras");
        System.out.println("P.-cables viajeros");
        System.out.println("Q.-otros sistemas");
        do {
            try {
                do {
                    o=al.valchar("\n\tSeleccione la opcion del servicio: ");
                    switch (o){
                    case 'a':
                        Scategoria.add("ubicacion de la maquina");
                        seguir = false;
                       break;
                    case 'b':
                        Scategoria.add("niveles de aceite");
                        seguir = false;
                        break;
                     case 'c':
                        Scategoria.add("freno de la maquina o motor");
                        seguir = false;
                        break;
                     case 'd':
                        Scategoria.add("rieles");
                        seguir = false;
                        break;
                     case 'e':
                        Scategoria.add("funcionamiento de control");
                        seguir = false;
                        break;
                     case 'f':
                        Scategoria.add("regulador final de parada");
                        seguir = false;
                        break;
                     case 'g':
                        Scategoria.add("señalizaciones");
                        seguir = false;
                        break;
                     case 'h':
                        Scategoria.add("operador de puertas");
                        seguir = false;
                        break;
                     case 'i':
                        Scategoria.add("seguridades");
                        seguir = false;
                        break;
                     case 'j':
                        Scategoria.add("funcionamiento de puertas de cabina");
                        seguir = false;
                        break;
                     case 'k':
                        Scategoria.add("alarma");
                        seguir = false;
                        break;
                     case 'l':
                        Scategoria.add("funcionamiento de puertas de pasillo");
                        seguir = false;
                        break;
                     case 'm':
                        Scategoria.add("fosa");
                        seguir = false;
                        break;
                     case 'n':
                        Scategoria.add("cables de traccion");
                        seguir = false;
                        break;
                     case 'o':
                        Scategoria.add("botoneras");
                        seguir = false;
                        break;
                     case 'p':
                        Scategoria.add("cables viajeros");
                        seguir = false;
                        break;
                     case 'q':
                        Scategoria.add("otros sistemas");
                        seguir = false;
                        break;
                    default:
                        System.out.println("\n\tOpcion incorrecta.");
                        seguir = true;
                        break;
                    }   
                } while (seguir==true);
            } catch (Exception e)   {
                System.out.println("Se debe de ingresar una letra: "+e);
                seguir = true;
            }
        } while(seguir==true);
        
        Scliente.add(al.valtext("\nIngrese el nombre del servicio: "));
        rep=true;
        do {
            try {
                seguir = true;
                do {
                    System.out.println();
                    System.out.println("\n\tTipo del servicio: ");
                    System.out.println("A.-Correctivo");
                    System.out.println("B.-Operativo");
                    System.out.println("C.-Preventivo");
                    o=al.valchar("\n\tSeleccione la opcion del servicio: ");
                    switch (o) {
                    case 'a':
                        Stipo.add("Correctivo");
                        seguir = false;
                       break;
                    case 'b':
                        Stipo.add("Operativo");
                        seguir = false;
                        break;
                    case 'c':
                        Stipo.add("Preventivo");
                        seguir = false;
                        break;
                    default:
                        System.out.println("\n\tOpcion incorrecta:"+Scategoria);
                        break;
                    }
                } while (seguir==true);
            } catch(Exception f)   {
                System.out.println("Se debe de ingresar una letra: "+f);
                seguir = true;
            }
        } while (seguir==true);
        
        System.out.println("\nIngrese la descripcion del servicio:");
        Sdescripcion.add(entrada.next());
        
        Scosto.add(al.valfloat("\nIngresa el costo del servicio: "));
        System.out.println("\nIngresa las observaciones con base al servicio:");
        Sobservaciones.add(entrada.next());      
        Sstatus S=new Sstatus();
        Sstatus.add(S.status());
        //TECNICOS
        System.out.println("\nIngresa el lugar del servicio:");
        Slugar.add(entrada.next());
        rep=true;
        do {
            try {
                do {
                    System.out.println("\n\tImportancia del servicio: ");
                    System.out.println("A.-Alta");
                    System.out.println("B.-Media");
                    System.out.println("C.-Sin prioridad");
                    o = al.valchar("\n\tSeleccione la opcion del servicio: ");
                    switch (o) {
                    case 'a':
                        Simportancia.add("Alta");
                        seguir = false;
                       break;
                    case 'b':
                        Simportancia.add("Media");
                        seguir = false;
                        break;
                    case 'c':
                        Simportancia.add("Sin prioridad");
                        seguir = false;
                        break;
                    default:
                        System.out.println("\n\tOpcion incorrecta.");
                        seguir = true;
                        break;
                    }
                } while (seguir==true);
            } catch(Exception e)   {
                System.out.println("Se debe de ingresar una letra: "+e);
                seguir = true;
            }
        } while (seguir==true);
        rep=true;
        do {
            try {
                do {
                    System.out.println("\n\tSeleccione el status del pago:");
                    System.out.println("A.-Realizado");
                    System.out.println("B.-Pendiente");
                    System.out.println();
                    o=al.valchar("\n\tSeleccione la opcion del status de pago del servicio: ");
                    switch (o) {
                    case 'a':
                        SstatusPago.add("realizado");
                        seguir = false;
                       break;
                    case 'b':
                        SstatusPago.add("pendiente");
                        seguir = false;
                        break;
                    default:
                        System.out.println("\n\tOpcion incorrecta.");
                        seguir = true;
                        break;
                    }
                } while (seguir==true);
            } catch(Exception f)   {
                System.out.println("Se debe de ingresar una letra: "+f);
                seguir = true;
            }
        } while (seguir==true);
        
        //AGENDAR
        /*Date fecha = new Date();
        DateFormat Sfecha = new SimpleDateFormat("dd//MM/yyyy");*/
        DateFormat Shora = new SimpleDateFormat("HH:mm:ss");
        System.out.println("\n\t");
        Sf.duracion(); //decir que agende
        Sfecha s=new Sfecha();
        Sduracion.add(Shora.format(s.agenda()));
        //Sfech.add(Sfecha.format(fecha));
        
        seguir = true;
        do  {
            System.out.println("Desea guardar o cancelar?");
            System.out.println("1) Guardar");
            System.out.println("2) Cancelar");
            opc=al.valint("Su opcion: ");
            switch (opc) {
                case 1:
                    Sfolio.add(al.folio());
                    System.out.println("Servicio guardado exitosamente.\nFolio: "+Sfolio.get(Sfolio.size()-1));
                    seguir=false;
                    break;
                case 2:
                    Scliente.remove(Scliente.size()-1);
                    Sdescripcion.remove(Scliente.size()-1);
                    Slugar.remove(Scliente.size()-1);
                    Scategoria.remove(Scliente.size()-1);
                    Scosto.remove(Scliente.size()-1);
                    Sduracion.remove(Scliente.size()-1);
                    Sobservaciones.remove(Scliente.size()-1);
                    SstatusPago.remove(Scliente.size()-1);
                    Simportancia.remove(Scliente.size()-1);
                    Stipo.remove(Scliente.size()-1);
                    Sstatus.remove(Scliente.size()-1);
                    System.out.println("\nRegistro cancelado.");
                    seguir=false;
                    break;
                default:
                    System.out.println("\nOpcion invalida.");
                    seguir=true;
                    break;
            }
        } while(seguir==true);
    }
    /*
     * BServicio method, search a product by folio, client and category
     * Doesn't use parameters
     * Use global variables: Integer opc, String Sserv, Boolean seguir
     *  ArrayList: Integer encontrados, Sfolio String Scategoria, Scliente, Sdescripcion;
     *  and local variables: String a
     * Doesn't return anything
    */
    public void BServicio()	{
        do	{
            for(opc=0;opc<encontrados.size();opc++)	{
                encontrados.remove(opc);
            }
			System.out.println("�Cual es el criterio de la busqueda?");
			System.out.println("1) Folio del Servicio");
			System.out.println("2) Cliente");
			System.out.println("3) Tipo");
			opc=al.valint("Su opcion: ");
			switch(opc)	{
				case 1:
                    opc=0;
					System.out.println("Ingresa el Folio del Servicio: ");
                                        Sserv=entrada.next();
					for(String a : Sfolio)	{
						if(a.contains(Sserv))	{
							encontrados.add(opc);
						}
						opc++;
					}
					seguir=false;
					break;
				case 2:
				opc=0;
					Sserv=al.valtext("Ingresa el Nombre del Cliente: ");
					for(String a : Scliente)	{
						if(a.contains(Sserv))	{
							encontrados.add(opc);
						}
						opc++;
					}
					seguir=false;
					break;
				case 3:
				opc=0;
					Sserv=al.valtext("Ingresa el Tipo de Servicio: ");
					for(String a : Stipo)	{
						if(a.contains(Sserv))	{
							encontrados.add(opc);
						}
						opc++;
					}
					seguir=false;
					break;
				default:
					System.out.println("Opcion incorrecta.");
					seguir=true;
					break;
			}
		} while(seguir==true);
		opc=0;
		
		// Selects the product
		if(encontrados.size()>1)	{
			do	{
				for(opc=0;opc<encontrados.size();opc++)	{
					System.out.println(encontrados.get(opc)+") \nCliente: ["+Scliente.get(Scliente.size()-1)+"]\nFolio:\t["+Sfolio.get(Scliente.size()-1)
                                            +"]\nDescripcion: ["+Sdescripcion.get(Scliente.size()-1)+"]\nDireccion: ["+Slugar.get(Scliente.size()-1)
                                            +"]\nCategoria: ["+Scategoria.get(Scliente.size()-1)+"]\nCosto:\t["+Scosto.get(Scliente.size()-1)+"]\nDuracion: ["+Sduracion.get(Scliente.size()-1)
                                            +"]\nObservaciones: ["+Sobservaciones.get(Scliente.size()-1)+"]\nPago:\t["+SstatusPago.get(Scliente.size()-1)
                                            +"]\nImportancia: ["+Simportancia.get(Scliente.size()-1)+"]\nTipo:\t["+Stipo.get(Scliente.size()-1)+"]\nStatus:\t["+Sstatus.get(Scliente.size()-1)+"]\n");
				}
				opc = al.valint("Seleccione el numero del servicio.");
				if(!encontrados.contains(opc))	{
					System.out.println("No existe ese valor.");
				}
				else	{
					System.out.println("Usted escogio:\nCliente: ["+Scliente.get(Scliente.size()-1)+"]\nFolio:\t["+Sfolio.get(Scliente.size()-1)
                                            +"]\nDescripcion: ["+Sdescripcion.get(Scliente.size()-1)+"]\nDireccion: ["+Slugar.get(Scliente.size()-1)
                                            +"]\nCategoria: ["+Scategoria.get(Scliente.size()-1)+"]\nCosto:\t["+Scosto.get(Scliente.size()-1)+"]\nDuracion: ["+Sduracion.get(Scliente.size()-1)
                                            +"]\nObservaciones: ["+Sobservaciones.get(Scliente.size()-1)+"]\nPago:\t["+SstatusPago.get(Scliente.size()-1)
                                            +"]\nImportancia: ["+Simportancia.get(Scliente.size()-1)+"]\nTipo:\t["+Stipo.get(Scliente.size()-1)+"]\nStatus:\t["+Sstatus.get(Scliente.size()-1)+"]\n");
					seguir=false;

					do	{
						// Chooses Delete Product OR Modify Product
						System.out.println("�Que accion desea realizar ahora?");
						//System.out.println("1)Eliminar\n2)Modificar");
						System.out.println("3)Salir");
						opc = al.valint("Su opcion: ");
						/*if(opc==1)	{
							eliminar(sc,i);
							seguir=false;
						}
						else if(opc==2)	{
							modificar(sc,i);
							seguir=false;
						}
						else*/ if(opc==3)	{
							System.out.println("Regresando al menu Servicios.");
							seguir=false;
						}
						else	{
							System.out.println("Opcion incorrecta.");
							seguir=true;
						}
					} while(seguir==true);
				}
			} while(seguir==true);
		}
		else if(encontrados.size()==1)	{
			System.out.println("Servicio encontrado:\nCliente: ["+Scliente.get(Scliente.size()-1)+"]\nFolio:\t["+Sfolio.get(Scliente.size()-1)
                                            +"]\nDescripcion: ["+Sdescripcion.get(Scliente.size()-1)+"]\nDireccion: ["+Slugar.get(Scliente.size()-1)
                                            +"]\nCategoria: ["+Scategoria.get(Scliente.size()-1)+"]\nCosto:\t["+Scosto.get(Scliente.size()-1)+"]\nDuracion: ["+Sduracion.get(Scliente.size()-1)
                                            +"]\nObservaciones: ["+Sobservaciones.get(Scliente.size()-1)+"]\nPago:\t["+SstatusPago.get(Scliente.size()-1)
                                            +"]\nImportancia: ["+Simportancia.get(Scliente.size()-1)+"]\nTipo:\t["+Stipo.get(Scliente.size()-1)+"]\nStatus:\t["+Sstatus.get(Scliente.size()-1)+"]\n");

			do	{
				System.out.println("�Que accion desea realizar ahora?");
				//System.out.println("1)Eliminar\n2)Modificar");
				System.out.println("3)Salir");
				opc = al.valint("");
				/*if(opc==1)	{
					eliminar(sc,encontrados.get(0));
					seguir=false;
				}
				else if(opc==2)	{
					modificar(sc,encontrados.get(0));
					seguir=false;
				}
				else*/ if(opc==3)	{
					System.out.println("Regresando al menu Productos.");
					seguir=false;
				}
				else	{
					System.out.println("Opcion incorrecta.");
					seguir=true;
				}
			} while(seguir==true);
		}
		else if(encontrados.isEmpty())	{
			System.out.println("No se encontro: "+Sserv);
		}
		for(opc=0;opc<encontrados.size();opc++)	{
			encontrados.remove(opc);
		}
	}
}