#ifndef STAGE1_H
#define STAGE1_H

#include <QMainWindow>
#include "LampControl.h"

using namespace std;

QT_BEGIN_NAMESPACE
namespace Ui { class Stage1; }
QT_END_NAMESPACE

class Stage1 : public QMainWindow
{
    Q_OBJECT

    private:
        Ui::Stage1 *ui;
        Lampview *lamp;
        Cloud* c;
        LampControl* control;

    public:
        Stage1(QWidget *parent = nullptr);  //Constructor
        ~Stage1();                          //Destructor
        void powerButtonClicked();          //Cambia el estado de la lampara
        void setup();                       //Crea todas las clases necesarias para el funcionamiento del programa

    private slots:
        void on_pushButton_clicked(); //Prende o apaga la lampara cuando se apreta el boton de la ventana
};
#endif // STAGE1_H
