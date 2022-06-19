#ifndef LAMP_H
#define LAMP_H

// Quiza deberia ser QObject
#include <QWidget>
#include <QPainter>

class Lamp : public QWidget
{
    Q_OBJECT
public:
    explicit Lamp(int channel, QWidget *parent = 0);

    void changePowerState();

signals:
    void changedPowerState();

public slots:
    void setPowerState();

private:
    int lampChannel;
    bool state;

};

#endif // LAMP_H
