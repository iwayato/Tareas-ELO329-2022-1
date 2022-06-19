#ifndef STAGE1_H
#define STAGE1_H
#include <QMainWindow>

QT_BEGIN_NAMESPACE
namespace Ui{
    class Stage1;
    class Lamp;
}
QT_END_NAMESPACE

class Stage1 : public QMainWindow
{
    Q_OBJECT

    public:
        Stage1(QWidget *parent = nullptr);
        ~Stage1();

    private:
        Ui::Stage1 *ui;
};

#endif // STAGE1_H
