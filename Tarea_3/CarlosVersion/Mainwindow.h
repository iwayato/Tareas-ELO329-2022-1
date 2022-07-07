#ifndef MAINWINDOW_H
#define MAINWINDOW_H

#include <QMainWindow>
#include "LampView.h"
#include <vector>

using namespace std;
class QSlider;

QT_BEGIN_NAMESPACE
namespace Ui { class MainWindow; }
QT_END_NAMESPACE

class MainWindow : public QMainWindow
{
    Q_OBJECT

public:
    MainWindow(QWidget *parent = nullptr);
    ~MainWindow();
    void powerButtonClicked();


private slots:
    void on_pushButton_clicked();
    void on_horizontalSliderI_valueChanged(int value);
    void on_horizontalSliderR_valueChanged(int value);
    void on_horizontalSliderG_valueChanged(int value);
    void on_horizontalSliderB_valueChanged(int value);
    void on_spinBox_valueChanged(int arg1);
    void on_actionIntensity_triggered();
    void on_actionRGB_triggered();

private:
    Ui::MainWindow *ui;
    vector <LampView*> Vistas;

    QSlider* sliderI;
    QSlider* sliderR;
    QSlider* sliderG;
    QSlider* sliderB;
    int CurrentChannel;
    bool controlType; //false = intensity; true = RGB

};
#endif // MAINWINDOW_H
