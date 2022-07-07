#include "Mainwindow.h"
#include "ui_Mainwindow.h"
#include <QGraphicsScene>
#include <QSlider>

MainWindow::MainWindow(QWidget *parent)
    : QMainWindow(parent)
    , ui(new Ui::MainWindow)
{
    ui->setupUi(this);

    controlType = false;
    QGraphicsView* GraphicView1 = ui->graphicsView;
    LampView* VistaLampara1 = new LampView(2);
    Vistas.push_back(VistaLampara1);
    GraphicView1->setScene(VistaLampara1);

    QGraphicsView* GraphicView2 = ui->graphicsView_2;
    LampView* VistaLampara2 = new LampView(3);
    Vistas.push_back(VistaLampara2);
    GraphicView2->setScene(VistaLampara2);

    sliderI = new QSlider(this);
    sliderR = new QSlider(this);
    sliderG = new QSlider(this);
    sliderB = new QSlider(this);

    sliderI->setMaximum(255);
    sliderR->setMaximum(255);
    sliderG->setMaximum(255);
    sliderB->setMaximum(255);

    sliderI->setMinimum(0);
    sliderR->setMinimum(0);
    sliderG->setMinimum(0);
    sliderB->setMinimum(0);

    sliderI->setOrientation(Qt::Horizontal);
    sliderR->setOrientation(Qt::Horizontal);
    sliderG->setOrientation(Qt::Horizontal);
    sliderB->setOrientation(Qt::Horizontal);

    QObject::connect(sliderI,&QSlider::sliderMoved,this,&MainWindow::on_horizontalSliderI_valueChanged);
    QObject::connect(sliderR,&QSlider::sliderMoved,this,&MainWindow::on_horizontalSliderR_valueChanged);
    QObject::connect(sliderG,&QSlider::sliderMoved,this,&MainWindow::on_horizontalSliderG_valueChanged);
    QObject::connect(sliderB,&QSlider::sliderMoved,this,&MainWindow::on_horizontalSliderB_valueChanged);

    ui->verticalLayout->addWidget(sliderI);
    ui->verticalLayout->addWidget(sliderR);
    ui->verticalLayout->addWidget(sliderG);
    ui->verticalLayout->addWidget(sliderB);

    sliderR->setVisible(false);
    sliderG->setVisible(false);
    sliderB->setVisible(false);
}

MainWindow::~MainWindow()
{
    delete ui;

}

void MainWindow::powerButtonClicked()
{
    int x = Vistas.size();
    for(int i = 0; i < x; i++)
    {
        if((Vistas.at(i)->getChannel()) == CurrentChannel)
        {
            Vistas.at(i)->ChangeState();
        }
    }
}


void MainWindow::on_pushButton_clicked()
{
    powerButtonClicked();
}


void MainWindow::on_horizontalSliderI_valueChanged(int value)
{
    int x = Vistas.size();
    for(int i = 0; i < x; i++)
    {
        if((Vistas.at(i)->getChannel()) == CurrentChannel)
        {
            Vistas.at(i)->ChangeIntensity(value);
        }
    }
}

void MainWindow::on_horizontalSliderR_valueChanged(int value)
{
    int x = Vistas.size();
    for(int i = 0; i < x; i++)
    {
        if((Vistas.at(i)->getChannel()) == CurrentChannel)
        {
            Vistas.at(i)->ChangeR(value);
        }
    }
}

void MainWindow::on_horizontalSliderG_valueChanged(int value)
{
    int x = Vistas.size();
    for(int i = 0; i < x; i++)
    {
        if((Vistas.at(i)->getChannel()) == CurrentChannel)
        {
            Vistas.at(i)->ChangeG(value);
        }
    }
}

void MainWindow::on_horizontalSliderB_valueChanged(int value)
{
    int x = Vistas.size();
    for(int i = 0; i < x; i++)
    {
        if((Vistas.at(i)->getChannel()) == CurrentChannel)
        {
            Vistas.at(i)->ChangeB(value);
        }
    }
}


void MainWindow::on_spinBox_valueChanged(int arg1)
{
    CurrentChannel = arg1;
}


void MainWindow::on_actionIntensity_triggered()
{
    sliderI->setVisible(true);
    sliderI->setSliderPosition(0);

    sliderR->setVisible(false);
    sliderG->setVisible(false);
    sliderB->setVisible(false);

    int x = Vistas.size();
    for(int i = 0; i < x; i++)
    {
        Vistas.at(i)->setDefault();
    }

}


void MainWindow::on_actionRGB_triggered()
{
    sliderI->setVisible(false);

    sliderR->setVisible(true);
    sliderR->setSliderPosition(0);

    sliderG->setVisible(true);
    sliderG->setSliderPosition(0);

    sliderB->setVisible(true);
    sliderB->setSliderPosition(0);

    int x = Vistas.size();
    for(int i = 0; i < x; i++)
    {
        Vistas.at(i)->setDefault();
    }
}

