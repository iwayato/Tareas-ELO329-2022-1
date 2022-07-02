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
        Stage1(QWidget *parent = nullptr);
        ~Stage1();
        void powerButtonClicked();
        void setup();

    private slots:
        void on_pushButton_clicked();
};
#endif // STAGE1_H
