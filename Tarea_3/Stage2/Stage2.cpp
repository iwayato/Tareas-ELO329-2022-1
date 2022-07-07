#include "Stage2.h"
#include "ui_Stage2.h"
#include <QGraphicsScene>
#include <QSlider>

Stage2::Stage2(QWidget *parent)
    : QMainWindow(parent)
    , ui(new Ui::Stage2)
{
    ui->setupUi(this);

    setup();  //Se preparan las clases correspondientes

    QGraphicsView* GraphicView1 = ui->graphicsView;
    GraphicView1->setScene(lamp);  //Se agrega la lampara a la vista grafica de la ventana

    ui->SliderI->setMaximum(255);
    ui->SliderI->setMinimum(0);

    QObject::connect(ui->SliderI,&QSlider::sliderMoved,this,&Stage2::on_horizontalSliderI_valueChanged);
}

Stage2::~Stage2()
{
    delete ui;
}

void Stage2::setup()
{
    lamp = new Lampview();
    c = new Cloud(lamp);
    control = new LampControl(c);
}

void Stage2::powerButtonClicked()
{
    control->ButtonPressed();
}

void Stage2::on_horizontalSliderI_valueChanged(int value)
{
    control->ChangeIntensity(value);
}

void Stage2::on_pushButton_clicked()
{
    powerButtonClicked();
}
