#include "Stage3.h"
#include "ui_Stage3.h"
#include <QGraphicsScene>
#include <QSlider>

Stage3::Stage3(QWidget *parent)
    : QMainWindow(parent)
    , ui(new Ui::Stage3)
{
    ui->setupUi(this);

    // Se crea las dos lámparas, la nube y el control
    lamp1 = new Lampview(2);
    lamp2 = new Lampview(3);
    c = new Cloud();
    control = new LampControl(c);

    // Se añaden las lámparas a la nube
    c->addLampView(lamp1);
    c->addLampView(lamp2);

    //Se agregan las lámparas a las vistas graficas de la ventana
    QGraphicsView* GraphicView1 = ui->graphicsView;
    GraphicView1->setScene(lamp1);
    QGraphicsView* GraphicView2 = ui->graphicsView_2;
    GraphicView2->setScene(lamp2);

    // Se fija los límites del slider
    ui->SliderI->setMaximum(255);
    ui->SliderI->setMinimum(0);

    QObject::connect(ui->SliderI,&QSlider::sliderMoved,this,&Stage3::on_horizontalSliderI_valueChanged);
}

Stage3::~Stage3()
{
    delete ui;
}

void Stage3::on_pushButton_clicked()
{
    powerButtonClicked();
}

void Stage3::on_horizontalSliderI_valueChanged(int value)
{
    control->ChangeIntensity(CurrentChannel, value);
}

void Stage3::on_spinBox_valueChanged(int arg1)
{
    CurrentChannel = arg1;
}

void Stage3::powerButtonClicked()
{
    control->ButtonPressed(CurrentChannel);
}
