#include "Stage1.h"
#include "ui_Stage1.h"
#include <QGraphicsScene>

Stage1::Stage1(QWidget *parent)
    : QMainWindow(parent)
    , ui(new Ui::Stage1)
{
    ui->setupUi(this);

    QGraphicsView* GraphicView1 = ui->graphicsView;
    lamp = new Lampview();
    GraphicView1->setScene(lamp);
}

Stage1::~Stage1()
{
    delete ui;
}

void Stage1::powerButtonClicked()
{
    lamp->ChangeState();
}

void Stage1::on_pushButton_clicked()
{
    powerButtonClicked();
}

