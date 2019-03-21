from numpy import *

def llegadas(fluc_min, fluc_max):
    while True:
        prob = []
        for x in range(fluc_min, fluc_max):
            prob = float(input("Ingrese la probabilidad de"))
        if sum(prob) != 100:
            print("ERROR: La probabilidad total no da 100%. Revise las cantidades.")
            continue
        elif:
            print(">>100%<<")
            break

def descargas(fluc_min, fluc_max):
    while True:
        prob = []
        for x in range(fluc_min, fluc_max):
            prob = float(input("Ingrese la probabilidad del índice {0} de descargas diarias"))
        if sum(prob) != 100:
            print("ERROR: La probabilidad total no da 100%. Revise las cantidades.")

def ops():
        while True:
            fluc_min = int(input("¿Cuál es la cantidad mínima de embarcaciones en la fluctuación diaria?\n"));
            fluc_max = int(input("¿Cuál es la cantidad máxima de embarcaciones en la fluctuación diaria?\n"));
            if fluc_max > fluc_min:
                    print(">>Datos correctos<<")
                    llegadas(fluc_min,fluc_max)
                    break
            else:
                    print("ERROR: La cantidad máxima es menor a la mínima.")
                    continue
        while True:
            ind_desc_min = int(input(""))
            ind_desc_max = int(input(""))
            if ind_desc_max > ind_desc_min:
                print(">>Datos correctos<<")
                descargas(ind_desc_min, ind_desc_max)
                break
            elif ind_desc_min == ind_desc_max:
                print("ADVERTENCIA: valor único.")
                descargas(ind_desc_min, ind_desc_max)
                break
            else:
                print("ERROR: La cantidad máxima es menor a la mínima")
                continue
        cost_emb = float(input("¿Cuál es el costo por embarcación pendiente para el día siguiente?\n"))
        cost_pers = float(input("¿Cuál es el costo de personal extra para las operaciones de descarga por día?\n"))
        dia = int(input("¿Cuántos días se desea simular?\n"));
        pend = []
        llegadas_aleat = []
        llegadas = []
        llegadasTotal = []
        descargas_aleat = []
        descargas = []
        linea_espera = []
        for x in range(dia):
                pend.append(int(input("Ingrese las embarcaciones pendientes del día {0}:\n".format(x+1))))
                llegadas_aleat = random.randint(00,99)
                
                descargas_aleat = random.randint(00,99)

        print("\tDía","\tN° Pendiente del día anterior","\tN° Aleatorio de llegadas",
                "\tSimulación de llegadas noct.","\tTotal pendiente por descargar",
                "\tN° Aleatorio de descargas","\tN° de descargas","\tLínea de espera",
                "\tDías personal. Descarga ocioso","\tCosto de personal extra",
                "\tCosto de embarcación en espera".rjust(10))
        for x in range(dia):
                print(x)

def main():
    ops()

main()
