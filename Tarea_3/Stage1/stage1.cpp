#include "stage1.h"
#include "ui_stage1.h"
#include "lamp.h"

// Constructor de ventana principal, se inicializa con el constructor de
// QMainWindow y se inicializa el atributo privado ui
Stage1::Stage1(QWidget *parent) :
    QMainWindow(parent),
    ui(new Ui::Stage1)
{
    // Le agrega a la MainWindow, todos los elementos que se configuraron a través de QtDesigner
    ui->setupUi(this);

    Lamp lamp(1);

}

Stage1::~Stage1(){
    delete ui;
}



