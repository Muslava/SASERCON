package Login;

import java.util.*;
import java.io.*;

public class Productos {

	static private int Pclave, Pnumero_de_productos, Pumbral;
	static private float Pcantidad_minima, Pcantidad_maxima;
	static private Date Ptiempo_de_entrega = new Date();
	static public float Ppeso_maximo;
	static public int Pcodigo_de_barras;
	static public ArrayList<String> Pnombre_del_producto = new ArrayList<String>() {{
		add("botonera");
		add("pasamanos");
		add("escalon");
	}}, Pdescripcion_del_producto = new ArrayList<String>()	{{
		add("modular centrada en pa�o con chasis de mochila y desplazada en chasis de portico");
		add("tubular recto de acero esmerelizado");
		add("escalon acero para escalera electrica 10 mts");
	}}, Pmodelo = new ArrayList<String>()	{{
		add("LTK-3");
		add("PMS-0");
		add("506 S");
	}}, Pfamilia = new ArrayList<String>()	{{
		add("elevadores");
		add("elevadores");
		add("escaleras electricas");
	}}, Pmarca = new ArrayList<String>()	{{
		add("eros");
		add("hercules");
		add("otis");
	}}, Pcodigo_fabricante = new ArrayList<String>()	{{
		add("shindler");
		add("shindler");
		add("otis");
	}}, Punidad_de_peso = new ArrayList<String>()	{{
		add("kg");
		add("kg");
		add("mts");
	}}, Punidad_de_medida = new ArrayList<String>()	{{
		add("kg");
		add("kg");
		add("mts");
	}}, Pforma_de_entrega = new ArrayList<String>()	{{
		add("por envio");
		add("por envio");
		add("por envio");
	}}, Pclasificacion_del_producto = new ArrayList<String>()	{{
		add("activo fijo");
		add("activo fijo");
		add("activo fijo");
	}}, Pstatus = new ArrayList<String>()	{{
		add("en uso");
		add("en uso");
		add("en uso");
	}};
	static public ArrayList<ArrayList<String>> Producto = new ArrayList<ArrayList<String>>()	{{
		add(Pnombre_del_producto);
		add(Pmodelo);
		add(Pfamilia);
		add(Pmarca);
		add(Pcodigo_fabricante);
		add(Pdescripcion_del_producto);
		add(Punidad_de_peso);
		add(Punidad_de_medida);
		add(Pforma_de_entrega);
		add(Pclasificacion_del_producto);
		add(Pstatus);
	}};

	// Global variables declaration: Int i, opc, String Pprod, Boolean rep;
	static ArrayList<Integer> encontrados = new ArrayList<Integer>();
	static int i=0, opc=0;
	static String Pprod=null;
	static boolean rep=true;

	static ALERTA al = new ALERTA();
	static Scanner sc = new Scanner(System.in);

	/* Pmenu allows to accede to the different options
	 * Doesn't use parameters
	 * Use global varibles: int i, 
	 * Doesn't return anything */
	public void Pmenu()	{
		do	{
			System.out.println("\nQue accion desea realizar en Productos?");
			//System.out.println("1) Imprimir");
			System.out.println("1) Ingresar");
			/*System.out.println("3) Asignar");
			System.out.println("4) Cotizar");*/
			System.out.println("2) Mostrar");
			//System.out.println("6) Guardar");
			//System.out.println("7) Cancelar");
			//System.out.println("8) Seleccionar");
			System.out.println("3) Buscar (eliminar o buscar)");
			/*System.out.println("10) Desplegar");
			System.out.println("11) Asignar codigo de barras");*/
			System.out.println("4) Regresar");
			i = al.valint("\nSu opcion: ");
			switch(i)	{
				case 1:
					//imprimir(sc);
					ingresar(sc);
					break;
				case 2:
					//ingresar(sc);
					mostrar(sc);
					break;
				case 3:
					//asignar(sc);
					buscar(sc);
					break;
				case 4:
					//cotizar(sc);
					rep=cancelar();
					break;
				/*case 5:
					mostrar(sc);
					break;
				case 6:
					guardar(sc);
					break;
				case 7:
					rep=cancelar();
					break;
				case 8:
					seleccionar(sc);
					break;
				case 9:
					buscar(sc);
					break;
				case 10:
					desplegar(sc);
					break;
				case 11:
					asignarcodigobarras(sc);
					break;
				case 12:
					rep=cancelar();
					break;
				case 99:
					prueba(sc);
					break; */
				default:
					System.out.println("Opcion incorrecta, favor de ingresar una correcta.");
					rep=true;
                                        break;
			}
		} while(rep==true);
	}

	static public void prueba(Scanner sc)	{
	}

	/* imprimir method, prints a product or several products info
	 * Parameters
	 * Variables
	 * Return
	 */
	static public void imprimir(Scanner sc)	{
	}

	/* generar_documento_embalaje method, generates a PDF document for packaging
	 * Parameters
	 * Variables
	 * Return
	 */
	void generar_documento_embalaje(Scanner sc)	{
	}

	/* ingresar method, saves a detailed product, only if there's no other product with the same name or id
	 * It doesn't use parameters
	 * Local variables: integer existe, i; boolean rep; String dec; String nextRecord. Global variables: String Pnombre_del_producto
	 * It doesn't return anything
	 */
	static public void ingresar(Scanner sc)	{

		try	{
			System.out.println("\n\tIngresar");
			Pprod = al.valtext("Ingresa el nombre del producto: ");
			
			if(Pnombre_del_producto.contains(Pprod)==false)	{
				for(String a : Pnombre_del_producto)	{
					if(a.contains(Pprod)) encontrados.add(i);
				}
				Pnombre_del_producto.add(Pprod);
				System.out.print("Ingrese la descripcion de "+Pprod+": ");
				Pdescripcion_del_producto.add(sc.next());
				System.out.print("Ingrese el modelo: ");
				Pmodelo.add(sc.next());
				System.out.print("Ingrese la familia: ");
				Pfamilia.add(sc.next());
				System.out.print("Ingrese la marca: ");
				Pmarca.add(sc.next());
				System.out.print("Ingrese el codigo de fabricante: ");
				Pcodigo_fabricante.add(sc.next());
				rep=true;
				do {
					System.out.println("\n\t Ingrese la unidad de peso de "+Pprod+": ");
					System.out.println("\t\t1.-kg");
					System.out.println("\t\t2.-gr");
					System.out.println("\t\t3.-mg");
					opc=al.valint("Su opcion: ");
					switch (opc) {
		
						case 1:
							System.out.println("\n\t La unidad de peso es kg");
							Punidad_de_peso.add("kg");
							rep = false; 
							break;
		
						case 2:   
							System.out.println("\n\t La unidad de peso es gr");
							Punidad_de_peso.add("gr");
							rep = false;
							break;

						case 3:
							System.out.println("\n\t La unidad de peso es mg");
							Punidad_de_peso.add("mg");
							rep = false;
							break;
						default:
							System.out.println("\n\tOpcion incorrecta.");
							rep = true;
							break;
					}
				} while (rep==true);
				rep=true;
				do {
					System.out.println("\n\t Ingrese la unidad de medida");
					System.out.println("\t\t1.-mts");
					System.out.println("\t\t2.-cm");
					System.out.println("\t\t3.-mm");
					opc=al.valint("Su opcion: ");
					switch (opc) {
		
						case 1:
							System.out.println("\n\t La unidad de peso es mts");
							Punidad_de_medida.add("mts");
							rep = false; 
							break;
		
						case 2:   
							System.out.println("\n\t La unidad de peso es cm");
							Punidad_de_medida.add("cm");
							rep = false;
							break;

						case 3:
							System.out.println("\n\t La unidad de peso es mm");
							Punidad_de_medida.add("mm");
							rep = false;
							break;
						default:
							System.out.println("\n\tOpcion incorrecta.");
							rep = true;
							break;
					}
				} while (rep==true);
				Pforma_de_entrega.add(al.valtext("Ingrese la forma de entrega: "));
				rep=true;
				do {
					System.out.println("\n\t Ingrese la clasificacion del producto "+Pprod+": ");
					System.out.println("\t\t1.-Activo Fijo");
					System.out.println("\t\t2.-Activo Circulante");
					opc=al.valint("Su opcion: ");
					switch (opc) {
		
						case 1:
							System.out.println("\n\t La clasificacion del producto es Activo Fijo");
							Pclasificacion_del_producto.add("Activo Fijo");
							rep = false; 
							break;
		
						case 2:   
							System.out.println("\n\t La clasificacion del producto es Activo Circulante");
							Pclasificacion_del_producto.add("Activo Circulante");
							rep = false;
							break;

						default:
							System.out.println("\n\tOpcion incorrecta.");
							rep = true;
							break;
					}
				} while (rep==true);
				rep=true;
				do {
					System.out.println("\n\t Ingrese el status: "+Pprod);
					System.out.println("\t\t1.-Existente");
					System.out.println("\t\t2.-Inexistente");
					System.out.println("\t\t3.-De Baja");
					opc=al.valint("Su opcion: ");
					switch (opc) {
		
						case 1:
							System.out.println("\n\t El producto esta en Existencia");
							Pstatus.add("Existencia");
							rep = false; 
							break;
		
						case 2:   
							System.out.println("\n\t El producto esta en Inexistencia");
							Pstatus.add("Inexistencia");
							rep = false;
							break;

						case 3:
							System.out.println("\n\t El producto esta de Baja");
							Pstatus.add("Baja");
							rep = false;
							break;
						default:
							System.out.println("\n\tOpcion incorrecta.");
							rep = true;
							break;
					}
				} while (rep==true);

				// Shows the product that will be entered
				System.out.println("Se ingresara: "+"\n\tNombre:\t\t["+Pnombre_del_producto.get(Pstatus.size()-1)+"]\n\tModelo:\t\t["
					+Pmodelo.get(Pstatus.size()-1)+"]\n\tFamilia:\t["+Pfamilia.get(Pstatus.size()-1)+"]\n\tMarca:\t\t["+Pmarca.get(Pstatus.size()-1)
					+"]\n\tCodigo del Fab:\t["+Pcodigo_fabricante.get(Pstatus.size()-1)+"]\n\tDescripcion:\t["
					+Pdescripcion_del_producto.get(Pstatus.size()-1)+"]\n\tUn. de Peso:\t["+Punidad_de_peso.get(Pstatus.size()-1)+"]\n\tUn. de Medida:\t["
					+Punidad_de_medida.get(Pstatus.size()-1)+"]\n\tEntrega:\t["+Pforma_de_entrega.get(Pstatus.size()-1)+"]\n\tClasificacion:\t["
					+Pclasificacion_del_producto.get(Pstatus.size()-1)+"]\n\tStatus:\t\t["+Pstatus.get(Pstatus.size()-1)+"]");
				
				// Ask if the user wants to save the product info
				do {
					System.out.println("�Desea guardarlo?");
					System.out.println("1.-Si");
					System.out.println("2.-No");
					opc=al.valint("Su opcion: ");
					switch (opc) {
		
						case 1:
							// Saves
							System.out.println("Producto guardado con exito.");
							System.out.println("Lista de productos: "+Pnombre_del_producto);
							rep=false;
							break;
		
						case 2:   
							// Doesn't save
							Pnombre_del_producto.remove(Pstatus.size()-1);
							Pmodelo.remove(Pstatus.size()-1);
							Pfamilia.remove(Pstatus.size()-1);
							Pmarca.remove(Pstatus.size()-1);
							Pcodigo_fabricante.remove(Pstatus.size()-1);
							Pdescripcion_del_producto.remove(Pstatus.size()-1);
							Punidad_de_peso.remove(Pstatus.size()-1);
							Punidad_de_medida.remove(Pstatus.size()-1);
							Pforma_de_entrega.remove(Pstatus.size()-1);
							Pclasificacion_del_producto.remove(Pstatus.size()-1);
							Pstatus.remove(Pstatus.size()-1);
							System.out.println("Guardado cancelado.");
							rep = false;
							break;

						default:
							System.out.println("\n\tOpcion incorrecta.");
							rep = true;
							break;
					}
				} while (rep==true);
				rep=false;
			}
			else if(Pnombre_del_producto.contains(Pprod)==true)	{
				// Doesn't save and return to "Ingresar dato"
				System.out.println("El producto ya existe.");
				while(encontrados.size()!=0)	{
					encontrados.removeAll(encontrados);
				}
			}
		} catch(Exception e)	{
			System.out.println("Hubo un problema: "+e);
		}
	}

	/* modificar method modifies a product data previously selected
	 * Use two parameters: Scanner sc, Int i
	 * Variables
	 * Return
	 */
	static public void modificar(Scanner sc, int i)	{
		try	{
			System.out.println("�Modifiquemos!");
			// Solo los campos modificables

		} catch(Exception e)	{
			System.out.println("Hubo un problema: "+e);
		}
	}
	
	/* eliminar method changes the product status to: eliminado, baja, descontinuado
	 * Use two parameters: Scanner sc, int i
	 * Use global variables: ArrayList<String> Pstatus, Boolean rep, char opc
	 * Doesn't return anything
	 */
	static public void eliminar(Scanner sc, int i)	{
		System.out.println("\t\tEliminar");
		do	{
			System.out.println("a) Eliminar");
			System.out.println("b) Dar de baja");
			System.out.println("c) Descontinuar");
			System.out.println("d) Cancelar");
			opc = al.valtext("Escoja la accion a realizar:").charAt(0);
			switch(opc)	{
				case 'a':
					Pstatus.set(i,"eliminado");
					System.out.println("Estado del producto: eliminado");
					rep=false;
					break;
				case 'b':
					Pstatus.set(i,"baja");
					System.out.println("Estado del producto: baja");
					rep=false;
					break;
				case 'c':
					Pstatus.set(i,"descontinuado");
					System.out.println("Estado del producto: descontinuado");
					rep=false;
					break;
				case 'd':
					System.out.println("Cancelado");
					rep=false;
					break;
				default:
					System.out.println("Opcion no valida.");
					rep=true;
					break;
			}
		} while(rep==true);
	}
	
	/* method
	 * Parameters
	 * Variables
	 * Return
	 */
	static public void asignar(Scanner sc)	{
	}
	
	/* method
	 * Parameters
	 * Variables
	 * Return
	 */
	static public void cotizar(Scanner sc)	{
	}
	
	/* mostrar method, shows every product data that Pstatus equals to "en uso"
	 * Parameters: Scanner sc
	 * Variables
	 * Doesn't return anything
	 */
	static public void mostrar(Scanner sc)	{
		System.out.println("\t\t\t<<<Productos>>>\n");
		for(i=0;i<Pnombre_del_producto.size();i++)	{
			if(!Pstatus.equals("eliminado") || !Pstatus.equals("baja") || !Pstatus.equals("descontinuado")) System.out.println("Producto "
				+(i+1)+"\n\tNombre:\t\t["+Pnombre_del_producto.get(i)+"]\n\tModelo:\t\t["+Pmodelo.get(i)+"]\n\tFamilia:\t["+Pfamilia.get(i)
				+"]\n\tMarca:\t\t["+Pmarca.get(i)+"]\n\tCodigo del Fab:\t["+Pcodigo_fabricante.get(i)+"]\n\tDescripcion:\t["
				+Pdescripcion_del_producto.get(i)+"]\n\tUn. de Peso:\t["+Punidad_de_peso.get(i)+"]\n\tUn. de Medida:\t["
				+Punidad_de_medida.get(i)+"]\n\tEntrega:\t["+Pforma_de_entrega.get(i)+"]\n\tClasificacion:\t["
				+Pclasificacion_del_producto.get(i)+"]\n\tStatus:\t\t["+Pstatus.get(i)+"]");
		}
	}
	
	/* method
	 * Parameters
	 * Variables
	 * Return
	 */
	static public void guardar(Scanner sc)	{
	}
	
	/* cancelar method returns to the main menu
	 * Doesn't use parameters
	 * Doesn't use variables
	 * Return a boolean value
	 */
	static public boolean cancelar()	{
		System.out.println("Regresando al Menu Principal");
		return false;
	}
	
	/* method
	 * Parameters
	 * Variables
	 * Return
	 */
	static public void seleccionar(Scanner sc)	{
	}
	
	/* buscar method, looks for a product info
	 * Doesn't use parameters
	 * Variables
	 * Doesn't return anything
	 */
	static public void buscar(Scanner sc)	{
		System.out.println("\t\tBusqueda");

		do	{
			System.out.println("�Cual es el criterio de la busqueda?");
			System.out.println("1) Nombre del producto");
			System.out.println("2) Modelo");
			System.out.println("3) Familia");
			System.out.println("4) Marca");
			i=al.valint("Su opcion: ");
			switch(i)	{
				case 1:
					i=0;
					Pprod=al.valtext("Ingresa el Nombre del producto: ");
					for(String a : Pnombre_del_producto)	{
						if(a.contains(Pprod))	{
							encontrados.add(i);
						}
						i++;
					}
					rep=false;
					break;
				case 2:
				i=0;
					System.out.println("Ingresa el Modelo del producto: ");
                                        Pprod = sc.next();
					for(String a : Pmodelo)	{
						if(a.contains(Pprod))	{
							encontrados.add(i);
						}
						i++;
					}
					rep=false;
					break;
				case 3:
				i=0;
					System.out.println("Ingresa la Familia del producto: ");
                                        Pprod = sc.next();
					for(String a : Pfamilia)	{
						if(a.contains(Pprod))	{
							encontrados.add(i);
						}
						i++;
					}
					rep=false;
					break;
				case 4:
				i=0;
					System.out.println("Ingresa la Marca del producto:");
                                        Pprod = sc.next();
					for(String a : Pmarca)	{
						if(a.contains(Pprod))	{
							encontrados.add(i);
						}
						i++;
					}
					rep=false;
					break;
				default:
					System.out.println("Opcion incorrecta.");
					rep=true;
					break;
			}
		} while(rep==true);
		i=0;
		
		// Selects the product
		if(encontrados.size()>1)	{
			do	{
				for(i=0;i<encontrados.size();i++)	{
					System.out.println(encontrados.get(i)+") ["+Pnombre_del_producto.get(encontrados.get(i))+"]\nDescripcion: ["+Pdescripcion_del_producto.get(encontrados.get(i))+"]");
				}
				i = al.valint("Seleccione el numero del producto.");
				if(!encontrados.contains(i))	{
					System.out.println("No existe ese valor.");
				}
				else	{
					System.out.println("Usted escogio: "+Pnombre_del_producto.get(i)+"\nDescripcion: "+Pdescripcion_del_producto.get(i));
					rep=false;

					do	{
						// Chooses Delete Product OR Modify Product
						System.out.println("�Que accion desea realizar ahora?");
						//System.out.println("1)Eliminar\n2)Modificar");
						System.out.println("3)Salir");
						opc = al.valint("Su opcion: ");
						/*if(opc==1)	{
							eliminar(sc,i);
							rep=false;
						}
						else if(opc==2)	{
							modificar(sc,i);
							rep=false;
						}
						else*/ if(opc==3)	{
							System.out.println("Regresando al menu Productos.");
							rep=false;
						}
						else	{
							System.out.println("Opcion incorrecta.");
							rep=true;
						}
					} while(rep==true);
				}
			} while(rep==true);
		}
		else if(encontrados.size()==1)	{
			System.out.println("Producto encontrado: "+Pnombre_del_producto.get(encontrados.get(0))+"\nDescripcion: "+Pdescripcion_del_producto.get(encontrados.get(0)));

			do	{
				System.out.println("�Que accion desea realizar ahora?");
				//System.out.println("1)Eliminar\n2)Modificar");
				System.out.println("3)Salir");
				opc = al.valint("");
				/*if(opc==1)	{
					eliminar(sc,encontrados.get(0));
					rep=false;
				}
				else if(opc==2)	{
					modificar(sc,encontrados.get(0));
					rep=false;
				}
				else*/ if(opc==3)	{
					System.out.println("Regresando al menu Productos.");
					rep=false;
				}
				else	{
					System.out.println("Opcion incorrecta.");
					rep=true;
				}
			} while(rep==true);
		}
		else if(encontrados.size()==0)	{
			System.out.println("No se encontro: "+Pprod);
		}
		for(i=0;i<encontrados.size();i++)	{
			encontrados.remove(i);
		}
	}
	
	/* method
	 * Parameters
	 * Variables
	 * Return
	 */
	static public void desplegar(Scanner sc)	{
	}
	
	/* method
	 * Parameters
	 * Variables
	 * Return
	 */
	static public void asignarcodigobarras(Scanner sc)	{
	}
}
