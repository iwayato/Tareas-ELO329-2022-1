#ifndef STAGE3_H
#define STAGE3_H

#include <QMainWindow>
#include "LampControl.h"

QT_BEGIN_NAMESPACE
namespace Ui { class Stage3; }
QT_END_NAMESPACE

class Stage3 : public QMainWindow
{
    Q_OBJECT

    private:
        Ui::Stage3 *ui;
        Lampview *lamp1;
        Lampview *lamp2;
        Cloud* c;
        LampControl* control;
        int CurrentChannel;

    public:
        Stage3(QWidget *parent = nullptr); // Constructor
        ~Stage3(); //Destructor
        void powerButtonClicked(); //Cambia el estado de la lampara
        void setup();  //Crea todas las clases necesarias para el funcionamiento del programa

    private slots:
        void on_pushButton_clicked(); //Prende o apaga la lampara cuando se apreta el boton de la ventana
        void on_horizontalSliderI_valueChanged(int value);
        void on_spinBox_valueChanged(int arg1);
};
#endif // STAGE2_H
