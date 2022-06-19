#include "stage1.h"
#include <QApplication>

int main(int argc, char *argv[])
{
    // Se crea una instancia de aplicación
    QApplication a(argc, argv);
    // Dentro de la aplicación se crea una instancia de Stage1
    Stage1 w;
    // Se muestra la ventana principal
    w.show();
    // Se ejecuta la aplicación gráfica
    return a.exec();
}
