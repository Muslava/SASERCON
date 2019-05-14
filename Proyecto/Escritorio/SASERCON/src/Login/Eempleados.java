
package Login;


import java.util.*;

public class Eempleados {
    ALERTA al = new ALERTA();
    /*Se declaran los arrelos*/
    public ArrayList<String> Ematricula = new ArrayList<String>()  {{
        add("0646BLP");
        add("6857PCJ");
        add("3498MYH");
    }}, Ecorreo = new ArrayList<String>()  {{
        add("otonram@gmail.com");
        add("betolazca@outlook.com");
        add("jimaguilar@gmail.com");
    }}, Enombre= new ArrayList<String>()  {{
        add("felix othon ramirez hernandez");
        add("humberto barraboza lazcano");
        add("erick yair jimenez aquiles");
    }}, Eempresa = new ArrayList<String>()  {{
        add("sercon");
        add("sercon");
        add("sercon");
    }};
    protected ArrayList<String> Edireccion = new ArrayList<String>()  {{
        add("Av Centenario. #1005, Colonia Gabriel Hernandez".toLowerCase());
        add("Gardenia #, Colonia Minas Palacio, Municipio: Naucalpan de Juarez.".toLowerCase());
        add("Asencion Almaraz, #3, Col. Abdiaz Garcia Soto, Cuajimalpa. CDMX".toLowerCase());
    }}, CURP= new ArrayList<String>()  {{
        add("");
        add("");
        add("");
    }}, RFC = new ArrayList<String>()  {{
        add("");
        add("");
        add("");
    }};
    public ArrayList<Long> Ecelular = new ArrayList<Long>()  {{
         add(5583547174l);
         add(5569168078l);
         add(5543314960l);
    }}, Etelefono  = new ArrayList<Long>()  {{
         add(5583877176l);
         add(5569268076l);
         add(5214314965l);
    }};
    protected ArrayList<Long> Etelefono_emergencia  = new ArrayList<Long>() {{
         add(5583547125l);
         add(5569168551l);
         add(5242314330l);
    }}, NSS = new ArrayList<Long>() {{
        add(0l);
        add(0l);
        add(72795608040l);
    }};
    protected ArrayList<String> Enombre_del_contacto = new ArrayList<String>()  {{
        add("");
        add("");
        add("");
    }}, Ecorreo_del_contacto = new ArrayList<String>()  {{
        add("");
        add("");
        add("");
    }};
    protected ArrayList<String> Estatus = new ArrayList<String>()   {{
        add("Activo");
        add("Activo");
        add("Activo");
    }};
    /*The arrays are declared
     * The global arrays are declared
     * String Eempl, Int opc, Boolean rep, seguir */
    static ArrayList<Integer> encontrados = new ArrayList<>();
    static boolean rep=true,seguir=true;
    static Scanner entrada =new Scanner(System.in);
    int opc;
    String Eempl;
   
    /* Emenu allows to accede to the empleados menu
     * Doesn't use parameters
     * Use global variables: int opc; Boolean rep=true
     * Doesn't return anything */
    public void Emenu() {
        do {
            System.out.println("\n\t  MENU");
            System.out.println("\t1.-Ingresar");
            System.out.println("\t2.-Buscar");
            System.out.println("\t3.-Regresar");
            opc = al.valint("Su opcion: ");

            switch(opc) {
        
            case 1:
                IEmpleado();
                rep=false;
                break;
            case 2:
                BEmpleado();
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
        } while(rep==true);
    }
        /*The ends method */

    /*IEmpleado allows to save new employees
      Use global variables: String Enombre,Eapellidop,Eapellidom,Ecorreo, p,c,Am,Ca,Ecurp,Erfc,ECnombre,ECapellidom,ECapellidop,ECcorreo,
      Int Ematricula,cP,nE,Enss,Ecelular,Etelefono,Etelefono_emergencia;
      Use global variable: Boolean seguir */
    public void IEmpleado() {

        //las variables utilizadas son tipo String Enombre,Eapellidop,Eapellidom,Ecorreo: y de tipo int Ematricula:
        System.out.println("\n\tEMPLEADO");
        String Enom=al.valtext("Ingrese el nombre del empleado\n");
        String Eapellidop=al.valtext("Ingrese su Apellido Paterno del contacto\n"); 
        String Eapellidom=al.valtext("Ingrese su Apellido Materno del contacto\n");  
        Ecorreo.add(al.valmail("Ingrese correo del empleado\n"));
        Enombre.add(Constructor(Enom,Eapellidop,Eapellidom));

        do  {
            System.out.println("\n\t\t Seleccione empresa a la que pertenece:");
            System.out.println("\t\t1.-Sercon");
            System.out.println("\t\t2.-ICC");
            System.out.println("\t\t3.-Samsara");
            System.out.println("\t\t4.-Maba");
            opc=al.valint("Su opcion: ");
            switch (opc)    {
                case 1:
                    System.out.println("\nPertenece a la empresa: Sercon");
                    Eempresa.add("Sercon");
                    seguir = false;
                    break;
                    
                case 2:
                    System.out.println("\nPertenece a la empresa: ICC");
                    Eempresa.add("ICC");
                    seguir = false;
                    break;
                    
                case 3:
                    System.out.println("\nPertenece a la empresa: Samsara");
                    Eempresa.add("Samsara");
                    seguir = false;
                    break;
                        
                case 4:
                    System.out.println("\nPertenece a la empresa: Maba");
                    Eempresa.add("Maba");
                    seguir = false;
                    break;
                        
                default:
                    System.out.println("\nOpcion incorrecta.");
                    seguir = true;
                    break;
            }
        
        } while (seguir==true);

    
        //las variables utilizadas son tipo String p,c,Am,Ca,Ecurp,Erfc,ECnombre,ECapellidom,ECapellidop,ECcorreo
        //y de tipo int cP,nE,Enss,Ecelular,Etelefono,Etelefono_emergencia
       
        System.out.println("\n\tIngrese la direccion del empleado");
        String p = al.valtext("\nPais: ");
        String c = al.valtext("\nCiudad: ");
        String am = al.valtext("\nAlcaldia-Municipio ");
        String ca = al.valtext("\ncalle ");
        int cp = al.valint("\nCodigo postal: ");
        int ne = al.valint("\nNumero exterior: ");
        Edireccion.add(Constructor(p,c,am,ca,cp,ne));
        
        System.out.println("\nIngresa el CURP: ");
        CURP.add(entrada.next());
        System.out.println("\nIngresa el RFC: ");
        RFC.add(entrada.next());
        NSS.add(al.valnss("Ingresa el NSS del empleado: "));
        Ecelular.add(al.numerotelefono("\nIngrese el celular del empleado: "));
        Etelefono.add(al.numerotelefono("\nIngrese el telefono del empleado: "));
        Etelefono_emergencia.add(al.numerotelefono("\nIngrese el telefono de emergencia: "));
        
        String Cnombre=al.valtext("\nIngrese nombre del contacto: "); 
        String Capellidop= al.valtext("\nIngrese sus Apellido Paterno del contacto: ");
        String Capellidom=al.valtext("\nIngrese sus Apellido Materno del contacto: ");
        Enombre_del_contacto.add(Constructor(Cnombre, Capellidop, Capellidom));
        
        Ecorreo_del_contacto.add(al.valmail("\nIngrese correo del contacto: "));


        do {
            System.out.println("\n\t\t Seleccione el status del empleado");
            System.out.println("\t\t1.-Activo");
            System.out.println("\t\t2.-Inactivo");
            System.out.println("\t\t3.-Dado de baja");
            opc=al.valint("Su opcion: ");
            switch (opc) {
                
            case 1:
                System.out.println("\n El empleado esta Activo");
                Estatus.add("Activo");
                seguir = false; 
                break;
            
            case 2:   
                System.out.println("\n El empleado esta Inactivo");
                Estatus.add("Inactivo");
                seguir = false;
                break;
                
            case 3:   
                System.out.println("\n El empleado esta dado de baja");
                Estatus.add("Baja");
                seguir = false;
                break;
                
            default:
                System.out.println("\nOpcion incorrecta.");
                seguir = true;
                break;
            }
        } while(seguir==true);
        
        do  {
            System.out.println("Desea guardar al empleado?: "+
                "]\nCorreo del empleado:\t["+Ecorreo.get(Estatus.size()-1)+
                "]\nNombre del empleado:\t["+Enombre.get(Estatus.size()-1)+
                "]\nEmpresa:\t\t["+Eempresa.get(Estatus.size()-1)+
                "]\nDireccion:\t\t["+Edireccion.get(Estatus.size()-1)+
                "]\nCURP:\t\t\t["+CURP.get(Estatus.size()-1)+
                "]\nRFC:\t\t\t["+RFC.get(Estatus.size()-1)+
                "]\nNSS:\t\t\t["+NSS.get(Estatus.size()-1)+
                "]\nCelular:\t\t["+Ecelular.get(Estatus.size()-1)+
                "]\nTelefono:\t\t["+Etelefono.get(Estatus.size()-1)+
                "]\nTelefono de emergencia: ["+Etelefono_emergencia.get(Estatus.size()-1)+
                "]\nNombre del contacto:\t["+Enombre_del_contacto.get(Estatus.size()-1)+
            "]\nCorreo del contacto:\t["+Ecorreo_del_contacto.get(Estatus.size()-1)+
            "]\nStatus:\t\t\t["+Estatus.get(Estatus.size()-1)+"]");
            System.out.println("1) Si\n2) No");
            opc=al.valint("Su opcion: ");
            switch (opc) {
                case 1:
                    Ematricula.add(al.matricula());
                    System.out.println("\nLa matricula del empleado es:" +Ematricula.get(Ematricula.size()-1));
                    seguir=false;
                    break;
                case 2:
                    System.out.println("\nRegistro cancelado.");
                    Ecorreo.remove(Ecorreo.size()-1);
                    Enombre.remove(Ecorreo.size()-1);
                    Eempresa.remove(Ecorreo.size()-1);
                    Edireccion.remove(Ecorreo.size()-1);
                    CURP.remove(Ecorreo.size()-1);
                    RFC.remove(Ecorreo.size()-1);
                    NSS.remove(Ecorreo.size()-1);
                    Ecelular.remove(Ecorreo.size()-1);
                    Etelefono.remove(Ecorreo.size()-1);
                    Etelefono_emergencia.remove(Ecorreo.size()-1);
                    Enombre_del_contacto.remove(Ecorreo.size()-1);
                    Ecorreo_del_contacto.remove(Ecorreo.size()-1);
                    Estatus.remove(Ecorreo.size()-1);
                    seguir=false;
                    break;
                default:
                    System.out.println("\nOpcion invalida.");
                    seguir=true;
                    break;
            }
  
        } while(seguir==true);
        
    }

    public static String Constructor(String a, String b, String c)   {
        return a+","+b+","+c;
    }

    public static String Constructor(String a, String b, String c, String d, int e, int f)   {
        return a+","+b+","+c+","+d+","+e+","+f;
    }

    /* BEmpleado allows to look for an employee registrated and saved in the array
     * Doesn't use parameters
     * Use global variables: Int opc
     * Doesn't use anything */
    public void BEmpleado()	{
        do	{
			System.out.println("Cual es el criterio de la busqueda?");
			System.out.println("1) Matricula del Empleado");
			System.out.println("2) Nombre del Empleado");
                        System.out.println("3) Correo del Empleado");
                        System.out.println("4) Empresa del Empleado");
			opc=al.valint("Su opcion: ");
			switch(opc)	{
				case 1:
                    opc=0;
                    System.out.println("Ingresa la Matricula del Empleado: ");
                    Eempl = entrada.next();
					for(String a : Ematricula)	{
						if(a.contains(Eempl))	{
							encontrados.add(opc);
						}
						opc++;
					}
					seguir=false;
					break;
				case 2:
				opc=0;
					Eempl=al.valtext("Ingresa el Nombre del Empleado:");
					for(String a : Enombre)	{
						if(a.contains(Eempl))	{
							encontrados.add(opc);
						}
						opc++;
					}
					seguir=false;
					break;
				case 3:
				opc=0;
					Eempl=al.valmail("Increse el Correo del Empleado:");
					for(String a : Ecorreo_del_contacto)	{
						if(a.contains(Eempl))	{
							encontrados.add(opc);
						}
						opc++;
					}
					seguir=false;
                    break;
                case 4:
				opc=0;
					Eempl=al.valtext("Increse la Empresa del Empleado:");
					for(String a : Eempresa)	{
						if(a.contains(Eempl))	{
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
					System.out.println(encontrados.get(opc)+") \nMatricula:\t\t["+Ematricula.get(Ematricula.size()-1)+
						"]\nCorreo del empleado:\t["+Ecorreo.get(Ematricula.size()-1)+
						"]\nNombre del empleado:\t["+Enombre.get(Ematricula.size()-1)+
						"]\nEmpresa:\t\t["+Eempresa.get(Ematricula.size()-1)+
						"]\nDireccion:\t\t["+Edireccion.get(Ematricula.size()-1)+
						"]\nCURP:\t\t\t["+CURP.get(Ematricula.size()-1)+
						"]\nRFC:\t\t\t["+RFC.get(Ematricula.size()-1)+
						"]\nNSS:\t\t\t["+NSS.get(Ematricula.size()-1)+
						"]\nCelular:\t\t["+Ecelular.get(Ematricula.size()-1)+
						"]\nTelefono:\t\t["+Etelefono.get(Ematricula.size()-1)+
						"]\nTelefono de emergencia: ["+Etelefono_emergencia.get(Ematricula.size()-1)+
						"]\nNombre del contacto:\t["+Enombre_del_contacto.get(Ematricula.size()-1)+
                        "]\nCorreo del contacto:\t["+Ecorreo_del_contacto.get(Ematricula.size()-1)+
                        "]\nStatus:\t\t\t["+Estatus.get(Ematricula.size()-1)+"]");
				}
				opc = al.valint("Seleccione el numero del empleado.");
				if(!encontrados.contains(opc))	{
					System.out.println("No existe ese valor.");
				}
				else	{
                    System.out.println("Usted selecciono:\nMatricula:\t\t["+Ematricula.get(Ematricula.size()-1)+
						"]\nCorreo del empleado:\t["+Ecorreo.get(Ematricula.size()-1)+
						"]\nNombre del empleado:\t["+Enombre.get(Ematricula.size()-1)+
						"]\nEmpresa:\t\t["+Eempresa.get(Ematricula.size()-1)+
						"]\nDireccion:\t\t["+Edireccion.get(Ematricula.size()-1)+
						"]\nCURP:\t\t\t["+CURP.get(Ematricula.size()-1)+
						"]\nRFC:\t\t\t["+RFC.get(Ematricula.size()-1)+
						"]\nNSS:\t\t\t["+NSS.get(Ematricula.size()-1)+
						"]\nCelular:\t\t["+Ecelular.get(Ematricula.size()-1)+
						"]\nTelefono:\t\t["+Etelefono.get(Ematricula.size()-1)+
						"]\nTelefono de emergencia: ["+Etelefono_emergencia.get(Ematricula.size()-1)+
						"]\nNombre del contacto:\t["+Enombre_del_contacto.get(Ematricula.size()-1)+
                        "]\nCorreo del contacto:\t["+Ecorreo_del_contacto.get(Ematricula.size()-1)+
                        "]\nStatus:\t\t\t["+Estatus.get(Ematricula.size()-1)+"]");
					seguir=false;

					do	{
						// Chooses Delete Product OR Modify Product
						System.out.println("Que accion desea realizar ahora?");
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
							System.out.println("Regresando al menu Empleados.");
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
            System.out.println("Empleado encontrado:\nMatricula:\t\t["+Ematricula.get(Ematricula.size()-1)+
                "]\nCorreo del empleado:\t["+Ecorreo.get(Ematricula.size()-1)+
                "]\nNombre del empleado:\t["+Enombre.get(Ematricula.size()-1)+
                "]\nEmpresa:\t\t["+Eempresa.get(Ematricula.size()-1)+
                "]\nDireccion:\t\t["+Edireccion.get(Ematricula.size()-1)+
                "]\nCURP:\t\t\t["+CURP.get(Ematricula.size()-1)+
                "]\nRFC:\t\t\t["+RFC.get(Ematricula.size()-1)+
                "]\nNSS:\t\t\t["+NSS.get(Ematricula.size()-1)+
                "]\nCelular:\t\t["+Ecelular.get(Ematricula.size()-1)+
                "]\nTelefono:\t\t["+Etelefono.get(Ematricula.size()-1)+
                "]\nTelefono de emergencia: ["+Etelefono_emergencia.get(Ematricula.size()-1)+
                "]\nNombre del contacto:\t["+Enombre_del_contacto.get(Ematricula.size()-1)+
                "]\nCorreo del contacto:\t["+Ecorreo_del_contacto.get(Ematricula.size()-1)+
                "]\nStatus:\t\t\t["+Estatus.get(Ematricula.size()-1)+"]");

			do	{
				System.out.println("Que accion desea realizar ahora?");
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
			System.out.println("No se encontro: "+Eempl);
		}
		for(opc=0;opc<encontrados.size();opc++)	{
			encontrados.remove(opc);
		}
	}
}