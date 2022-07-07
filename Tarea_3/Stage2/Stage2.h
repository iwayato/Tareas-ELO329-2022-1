#ifndef STAGE2_H
#define STAGE2_H

#include <QMainWindow>
#include "LampControl.h"

QT_BEGIN_NAMESPACE
namespace Ui { class Stage2; }
QT_END_NAMESPACE

class Stage2 : public QMainWindow
{
    Q_OBJECT

    private:
        Ui::Stage2 *ui;
        Lampview *lamp;
        Cloud* c;
        LampControl* control;

    public:
        Stage2(QWidget *parent = nullptr); // Constructor
        ~Stage2(); //Destructor
        void powerButtonClicked(); //Cambia el estado de la lampara
        void setup();  //Crea todas las clases necesarias para el funcionamiento del programa

    private slots:
        void on_pushButton_clicked(); //Prende o apaga la lampara cuando se apreta el boton de la ventana
        void on_horizontalSliderI_valueChanged(int value);
};
#endif // STAGE2_H
