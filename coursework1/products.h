
/*
    Products.h
    Author: M00696748
    Created: 22/12/2020
    Updated: 22/01/2021
*/

#ifndef Products_h
#define Products_h
#include <stdio.h>
#include <vector>
#include <string>


class Products {
private:
    int id;
    int stock = 100;
    int number_of_sales = 0;
    std::vector<int> items_list; 
public:
    void sellItems(); 
    void restockItems();
    void addnewItems();
    void correctStock(); 
    void salesandstockReport(); 
    void generate_products();
};

class Employee{
private:
    std::string name;
public:
    Employee();
    void enterName();
};

class Book : public Products {
private:
    int isbn_number;
public:
    Book();
    void getIsbn();
};

class Magazine : public Products {
private:
    std::string issn;
public:
    Magazine();
    void getIssn();
};

class DVD : public Products {
private:
    std::string title;
public:
    DVD();
    void getTitle();
};

class CD : public Products {
private:
    std::string genre;
public:
    CD();
    void getGenre();
};

#endif /* Products_h */
