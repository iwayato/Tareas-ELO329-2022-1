/********************************************************************************
** Form generated from reading UI file 'Stage1.ui'
**
** Created by: Qt User Interface Compiler version 6.3.1
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_STAGE1_H
#define UI_STAGE1_H

#include <QtCore/QVariant>
#include <QtWidgets/QApplication>
#include <QtWidgets/QGraphicsView>
#include <QtWidgets/QMainWindow>
#include <QtWidgets/QMenuBar>
#include <QtWidgets/QPushButton>
#include <QtWidgets/QStatusBar>
#include <QtWidgets/QVBoxLayout>
#include <QtWidgets/QWidget>

QT_BEGIN_NAMESPACE

class Ui_Stage1
{
public:
    QWidget *centralwidget;
    QVBoxLayout *verticalLayout;
    QGraphicsView *graphicsView;
    QPushButton *pushButton;
    QMenuBar *menubar;
    QStatusBar *statusbar;

    void setupUi(QMainWindow *Stage1)
    {
        if (Stage1->objectName().isEmpty())
            Stage1->setObjectName(QString::fromUtf8("Stage1"));
        Stage1->resize(573, 590);
        centralwidget = new QWidget(Stage1);
        centralwidget->setObjectName(QString::fromUtf8("centralwidget"));
        verticalLayout = new QVBoxLayout(centralwidget);
        verticalLayout->setObjectName(QString::fromUtf8("verticalLayout"));
        graphicsView = new QGraphicsView(centralwidget);
        graphicsView->setObjectName(QString::fromUtf8("graphicsView"));

        verticalLayout->addWidget(graphicsView);

        pushButton = new QPushButton(centralwidget);
        pushButton->setObjectName(QString::fromUtf8("pushButton"));

        verticalLayout->addWidget(pushButton);

        Stage1->setCentralWidget(centralwidget);
        menubar = new QMenuBar(Stage1);
        menubar->setObjectName(QString::fromUtf8("menubar"));
        menubar->setGeometry(QRect(0, 0, 573, 21));
        Stage1->setMenuBar(menubar);
        statusbar = new QStatusBar(Stage1);
        statusbar->setObjectName(QString::fromUtf8("statusbar"));
        Stage1->setStatusBar(statusbar);

        retranslateUi(Stage1);

        QMetaObject::connectSlotsByName(Stage1);
    } // setupUi

    void retranslateUi(QMainWindow *Stage1)
    {
        Stage1->setWindowTitle(QCoreApplication::translate("Stage1", "Stage1", nullptr));
        pushButton->setText(QCoreApplication::translate("Stage1", "On/Off", nullptr));
    } // retranslateUi

};

namespace Ui {
    class Stage1: public Ui_Stage1 {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_STAGE1_H
