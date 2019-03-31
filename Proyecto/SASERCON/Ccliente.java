package SASERCON;

import java.util.*;

public class Ccliente {
    Scanner entrada = new Scanner(System.in);
    static ALERTA al = new ALERTA();

    public ArrayList<String> Cfolio = new ArrayList<String>()   {{
       add("4479KGR");
       add("1305HRB");
    }};
    public ArrayList<String> CDireccionE = new ArrayList<String>()  {{
        add("Reforma # 220, Lomas de Reforma, Delegacion Cuauhtemoc");
        add("Juarez #4,colonia roma, CP 06600, Delegacion Cuauhtemoc");
    }}, CCRNombre = new ArrayList<String>() {{
        add("Joshua Lopez Gonzalez");
        add("Maria Magdalena Perez Mejia");
    }}, CCRCorreo = new ArrayList<String>() {{
        add("lope.goJoshua@amex.com.mx");
        add("Mamag1289@gmail.com.mx");
    }}, CRfc = new ArrayList<String>()  {{
        add("Log750329kl1");
        add("Pemm800312uhk");
    }}, CCECorreo = new ArrayList<String>() {{
        add("lope.goJoshua@amex.com.mx");
        add("Mamag1289@gmail.com.mx");
    }};
    private ArrayList<String> CDireccion = new ArrayList<String>()  {{
        add("Calle Aldama #35, Delegacion Cuajimalpa CP 05530");
        add("Ramon Fabie # 102, Colonia Lomas Altas, delegacion Miguel hidalgo");
    }};
    protected ArrayList<String> CNombre= new ArrayList<String>(){{
        add("Amex");
        add("Macuey");
    }},CDireccionF= new ArrayList<String>() {{
        add("Reforma # 220, Lomas de Reforma, Delegacion Cuauhtemoc");
        add("Glorieta de los Insurgentes s/n ");
    }};
    protected ArrayList<Integer> CExtencion= new ArrayList<Integer>(){{
        add(754);
        add(311);
    }};
    protected  ArrayList<Long> CTelfono_oficina= new ArrayList<Long>(){{
        add(5282537654l);
        add(5257654320l);
    }};
    static ArrayList<Integer> encontrados = new ArrayList<Integer>();

    public ArrayList<String> CStatus = new ArrayList<String>()  {{
        add("Activo");
        add("Inactivo");
    }};

    /*The global values are declared
     * Boolean seguir, Char empresa, String Ccliente, Int opc;
     * */

    static boolean seguir=true;
    public char empresa;
    public String Cclient;
    public int opc = 0;
    
    /* Cmenu allows to accede to each client option
     * Doesn't use parameters
     * Use variable Global: int opc,
     * Doesn't return anything */
    public void Cmenu() {
        do { 
            System.out.println("\n\t  MENU");
            System.out.println("\t1.-Ingresar");
            System.out.println("\t2.-Buscar");
            System.out.println("\t3.-Regresar");
            opc = al.valint("Su opcion: ");
        
        
            switch(opc) {
            
                case 1:
                    ICliente();
                    break;
                case 2:
                    BCliente();
                    break;
                case 3:
                    System.out.println("Regresando al Menu Principal");
                    seguir=false;
                    break;
                default:
                    System.out.println("\n\tOpcion incorrecta:");
                    break;
                }
        } while(seguir == true);
    }
    
    /*
     * ICliente allows to register a new client filling all data
     * Use local variables: String Pa,Ci,Am,Ca, Int Cp,Ne,Ni, int cp, ne, ni, i; and global variables: Boolean seguir, Int opc;
     * Doesn't use parameters
     * Doesn't return anything
    */
    public void ICliente() {

        CNombre.add(al.valtext("\n\tIngrese  nombre del cliente: "));

        
        System.out.println("\ta.-Sercon");
        System.out.println("\tb.-ICC");
        System.out.println("\tc.-Samsara");
        System.out.println("\td.-Maba");
        try {
            do {
                empresa=al.valtext("\n Seleccione empresa a la que pertenece: ").charAt(0);
                switch (empresa) {
                    case 'a':
                        System.out.println("\n Pertenece a la empresa: Sercon");
                        seguir = false;
                        break;

                    case 'b':   
                        System.out.println("\n Pertenece a la empresa: ICC");
                          seguir = false;
                          break;

                    case 'c':     
                        System.out.println("\n Pertenece a la empresa: Samsara");
                          seguir = false;
                          break;

                    case 'd':     
                        System.out.println("\n\t\t Pertenece a la empresa: Maba");
                          seguir = false;
                          break;

                    default:
                          System.out.println("\nOpcion incorrecta.");
                          seguir = true;
                          break;
                }
            } while (seguir==true);
        }catch(Exception e)   {
            System.out.println("No fue una letra: "+e);
        }

        System.out.println("");
        System.out.println("\n\tIngrese direccion del cliente.");
        String p = al.valtext("\nPais: ");
        String c = al.valtext("Ciudad: ");
        String am = al.valtext("Alcaldia-Municipio: ");
        System.out.print("Calle: ");
        String ca = entrada.next();
        int cp = al.valint("Codigo postal: ");
        int ne = al.valint("Numero exterior: ");
        int ni = al.valint("Nuemero interior: ");
        CTelfono_oficina.add(al.numerotelefono("Ingrese su telefono de oficina: "));
        CExtencion.add(al.valint("Ingresa extencion telefonica: "));
        String CRNombre = al.valtext("\n\tIngrese nombre del representante: ");
        String CApellidop = al.valtext("Ingrese su Apellido Paterno: ");
        String CApellidom = al.valtext("Ingrese su Apellido Materno: ");
        CCRNombre.add(Constructor(CRNombre, CApellidop, CApellidom));
        CCRCorreo.add(al.valmail("\tIngrese correo del representante: "));
        CCECorreo.add(al.valmail("\n\tIngrese correo empresarial: "));
        System.out.println("\nIngresa su RFC: "); //pendiente RFC
        CRfc.add(entrada.next());
        CDireccion.add(Constructor(p,c,am,ca,cp,ne,ni));

        System.out.println("\tIngrese direccion fiscal del cliente.");
        p = al.valtext("\nPais: ");
        c = al.valtext("Ciudad: ");
        am = al.valtext("Alcaldia-Municipio: ");
        System.out.print("Calle: ");
        ca = entrada.next();
        cp = al.valint("Codigo postal: ");
        ne = al.valint("Numero exterior: ");
        ni = al.valint("Numero interior: ");
        CDireccionF.add(Constructor(p,c,am,ca,cp,ne,ni));

        //variables donde se guardan son tipo String Pa,Ci,Am,Ca tipo Int Cp,Ne,Ni:
        System.out.println("\tIngrese direccion de entrega.");
        p = al.valtext("\nPais: ");
        c = al.valtext("Ciudad: ");
        am = al.valtext("Alcaldia-Municipio: ");
        System.out.print("Calle: ");
        ca = entrada.next();
        cp = al.valint("Codigo postal: ");
        ne = al.valint("Numero exterior: ");
        ni = al.valint("Numero interior: ");
        CDireccionE.add(Constructor(p,c,am,ca,cp,ne,ni));        

        do {
            System.out.println("\n\t Seleccione el status del cliente");
            System.out.println("\t\t1.-Activo");
            System.out.println("\t\t2.-Inactivo");
            opc=al.valint("Su opcion: ");
            switch (opc) {

                case 1:
                    System.out.println("\n\t El cliente esta Activo");
                    CStatus.add("Activo");
                    seguir = false; 
                    break;

                case 2:   
                    System.out.println("\n\t El cliente esta Inactivo");
                    CStatus.add("Inactivo");
                    seguir = false;
                    break;

                default:
                    System.out.println("\n\tOpcion incorrecta.");
                    seguir = true;
                    break;
            }
        } while (seguir==true);

        //fecha de alta y fecha de baja pendiente como realizar
       
        seguir = true;
        do  {
            System.out.println("�Desea guardar o cancelar?");
            System.out.println("1) Guardar");
            System.out.println("2) Cancelar");
            opc=al.valint("Su opcion: ");
            switch (opc) {
                case 1:
                    Cfolio.add(al.folio());
                    System.out.println("\nEl folio del nuevo cliente es: " +Cfolio.get(Cfolio.size()-1));
                    System.out.println("Cliente guardado exitosamente.");
                    seguir=false;
                    break;
                case 2:
                    CDireccionE.remove(Cfolio.size()-1);
                    CCRNombre.remove(Cfolio.size()-1);
                    CCRCorreo.remove(Cfolio.size()-1);
                    CRfc.remove(Cfolio.size()-1);
                    CDireccion.remove(Cfolio.size()-1);
                    CNombre.remove(Cfolio.size()-1);
                    CExtencion.remove(Cfolio.size()-1);
                    CTelfono_oficina.remove(Cfolio.size()-1);
                    CStatus.remove(Cfolio.size()-1);
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
   
    public String Constructor(String a, String b, String c, String d, int e, int f, int g)   {
        return a+", "+b+", "+c+", "+d+", "+e+", "+f+", "+g;
    }
    
    public static String Constructor(String a, String b, String c)   {
        return a+","+b+","+c;
    }

    /* buscar method, looks for a product info
	 * Doesn't use parameters
	 * Use local variables: String a
	 * Doesn't return anything
	 */
	public void BCliente()	{
        do	{
			System.out.println("�Cual es el criterio de la busqueda?");
			System.out.println("1) Folio del Cliente");
			System.out.println("2) Nombre del Representante");
			System.out.println("3) RFC");
			opc=al.valint("Su opcion: ");
			switch(opc)	{
				case 1:
                    opc=0;
                    System.out.println("Ingresa el Folio del Cliente: ");
					Cclient=entrada.next();
					for(String a : Cfolio)	{
						if(a.contains(Cclient))	{
							encontrados.add(opc);
						}
						opc++;
					}
					seguir=false;
					break;
				case 2:
				opc=0;
					Cclient=al.valtext("Ingresa el Nombre del Representante: ");
					for(String a : CCRNombre)	{
						if(a.contains(Cclient))	{
							encontrados.add(opc);
						}
						opc++;
					}
					seguir=false;
					break;
				case 3:
				opc=0;
					System.out.println("Ingresa el RFC: ");
					Cclient=entrada.next();
					for(String a : CRfc)	{
						if(a.contains(Cclient))	{
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
                    System.out.println(encontrados.get(opc)+") ["+Cfolio.get(encontrados.get(opc))
                        +"]\nCliente: ["+CNombre.get(encontrados.get(opc))+"]\nDireccion: ["+CDireccion.get(encontrados.get(opc))
                        +"]\nRepresentante: ["+CCRNombre.get(encontrados.get(opc))+"]");
				}
				opc = al.valint("Seleccione el numero del producto.");
				if(!encontrados.contains(opc))	{
					System.out.println("No existe ese valor.");
				}
				else	{
					System.out.println("Usted escogio: ["+Cfolio.get(encontrados.get(opc))
                        +"]\nCliente: ["+CNombre.get(encontrados.get(opc))+"]\nDireccion: ["+CDireccion.get(encontrados.get(opc))
                        +"]\nRepresentante: ["+CCRNombre.get(encontrados.get(opc))+"]");
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
							System.out.println("Regresando al menu Clientes.");
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
			System.out.println("Cliente encontrado: ["+Cfolio.get(encontrados.get(opc))
                +"]\nCliente: ["+CNombre.get(encontrados.get(opc))+"]\nDireccion: ["+CDireccion.get(encontrados.get(opc))
                +"]\nRepresentante: ["+CCRNombre.get(encontrados.get(opc))+"]");

			do	{
				System.out.println("�Que accion desea realizar ahora?");
				//System.out.println("1)Eliminar\n2)Modificar");
				System.out.println("3)Salir");
				opc = al.valint("Su opcion: ");
				/*if(opc==1)	{
					eliminar(sc,encontrados.get(0));
					seguir=false;
				}
				else if(opc==2)	{
					modificar(sc,encontrados.get(0));
					seguir=false;
				}
				else*/ if(opc==3)	{
					System.out.println("Regresando al menu Clientes.");
					seguir=false;
				}
				else	{
					System.out.println("Opcion incorrecta.");
					seguir=true;
				}
			} while(seguir==true);
		}
		else if(encontrados.size()==0)	{
			System.out.println("No se encontro: "+Cclient);
		}
		for(opc=0;opc<encontrados.size();opc++)	{
			encontrados.remove(opc);
		}
	}
   
    public String UsarFolio(String usr)    {
        if(Cfolio.contains(usr)) return usr;
        else return "ERROR";
    }
}
