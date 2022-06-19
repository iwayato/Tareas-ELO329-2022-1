/********************************************************************************
** Form generated from reading UI file 'stage1.ui'
**
** Created by: Qt User Interface Compiler version 5.15.2
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_STAGE1_H
#define UI_STAGE1_H

#include <QtCore/QVariant>
#include <QtWidgets/QApplication>
#include <QtWidgets/QMainWindow>
#include <QtWidgets/QMenuBar>
#include <QtWidgets/QStatusBar>
#include <QtWidgets/QWidget>

QT_BEGIN_NAMESPACE

class Ui_Stage1
{
public:
    QWidget *centralwidget;
    QMenuBar *menubar;
    QStatusBar *statusbar;

    void setupUi(QMainWindow *Stage1)
    {
        if (Stage1->objectName().isEmpty())
            Stage1->setObjectName(QString::fromUtf8("Stage1"));
        Stage1->resize(800, 600);
        Stage1->setStyleSheet(QString::fromUtf8(""));
        centralwidget = new QWidget(Stage1);
        centralwidget->setObjectName(QString::fromUtf8("centralwidget"));
        Stage1->setCentralWidget(centralwidget);
        menubar = new QMenuBar(Stage1);
        menubar->setObjectName(QString::fromUtf8("menubar"));
        menubar->setGeometry(QRect(0, 0, 800, 21));
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
    } // retranslateUi

};

namespace Ui {
    class Stage1: public Ui_Stage1 {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_STAGE1_H
