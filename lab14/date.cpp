#include <iostream>
#include <ostream>


class Date{

private:
  int day;
  int month;
  int year;
public:

   Date(int day , int month , int year) {
   this->day = day;
   this->month = month;
   this->year = year;
   }
   int getday() const { return this->day; }
   int getmonth() const { return this->month; }
   int getyear() const { return this->year; }
};

// comparing dates
bool operator <<(const Date& lhs , const Date& rhs) {

 if (lhs.getyear() < rhs.getyear()) {
 return true;
 } else if (lhs.getyear() == rhs.getyear() &&
 lhs.getmonth() < rhs.getmonth()) {
 return true;
 } else if (lhs.getyear() == rhs.getyear() &&
 lhs.getmonth() == rhs.getmonth() &&
 lhs.getday() < rhs.getday()) {
 return true;
 }

 return false;
}

// printing dates
 std :: ostream& operator <<(std :: ostream& out ,
 Date date) {
 out << date.getday() << '-' << date.getday() << '-'
 <<date.getday();
 return out;
}

void display(Date &date){
   std::cout<<date.getday()<<"-"<<date.getday()<<"-"<<date.getyear()<<"\n";
}

bool compare(const Date& lhs , const Date& rhs){
   if (lhs.getyear() < rhs.getyear()) {
 return true;
 } else if (lhs.getyear() == rhs.getyear() &&
 lhs.getmonth() < rhs.getmonth()) {
 return true;
 } else if (lhs.getyear() == rhs.getyear() &&
 lhs.getmonth() == rhs.getmonth() &&
 lhs.getday() < rhs.getday()) {
 return true;
}
}

int main(){

  Date D1(2,1,2021),D2(3,1,2021),D3(2,1,2021);
  display(D1);
  std::cout<<compare(D1,D2);
  std::cout<<compare(D1,D3);
  
  
return 0;
}
