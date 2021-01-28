#include<iostream>
#include<cstring>
using namespace std;

class node                                  //Class node
{
public:
int no;
string content;
node *next,*prev;
node(int i,string str)
{
no=i;
content=str;
next=prev=NULL;
}
friend class linkedlist;
friend class Queue;
};

class stack
{
   int top,max;
   char d;
   char stac[10];

public:

   stack()
{
  max=50;
  d=0;
  top=-1;
}

   void push(char d,int max);
   int isfull(int max);
   int isempty();
   char pop();
};

int stack::isfull(int max)
{
	if(top==max)
	return 0;
	else
	return 1;
}

int stack::isempty()
{
  if(top==-1)
  return 1;
  else
  return 0;
}

void stack::push(char d,int max)
{
  if(isfull(max)==1)
  {
	  top++;
	  stac[top]=d;
  }
}

char stack::pop()
{
  char i;
  if(isempty()==0)
  {
	i=stac[top];
	top--;
	return i;
  }
  else
  {
	  cout<<"No previous news seen"<<endl;
	  return 0;
  }
}
class linkedlist                        //Class for Linkedlist
{
public:
node *head;
linkedlist()
{
head=NULL;
}
};

class Queue                          //Class for Queue
{
int front,rear;
public:

Queue()
{
front=-1;
rear=0;
}
void hardcode_list();                  //Linkedlist
void hardcode_waitinglist();           //Queue
void Enqueue(string nam,int rn);
void Dequeue();
void Display_Admittedlist();
void Display_waitinglist();
void Withdraw(int g);
};
linkedlist l1;
linkedlist l2;

void Queue::hardcode_list()             //list stored in l1
{
node *temp,*ptr;

int i1,i2,i3,i4,i5,i6,i7;

string str1,str2,str3,str4,str5,str6,str7;

i1=171;
i2=161;
i3=156;
i4=148;
i5=135;
i6=122;
i7=120;

str1="Emma Watson";
str2="Rachel Willy";
str3="Monica Bings";
str4="Pheobe Margerita";
str5="Ananya Amara";
str6="Josephine bilgate";
str7="Yael Robert";

temp=new node(i1,str1);
l1.head=temp;
ptr=l1.head;
temp=new node(i2,str2);
ptr->next=temp;

ptr=ptr->next;
temp=new node(i3,str3);
ptr->next=temp;

ptr=ptr->next;
temp=new node(i4,str4);
ptr->next=temp;

ptr=ptr->next;
temp=new node(i5,str5);
ptr->next=temp;

ptr=ptr->next;
temp=new node(i6,str6);
ptr->next=temp;

ptr=ptr->next;
temp=new node(i7,str7);
ptr->next=temp;

}
void Queue::Enqueue(string nam,int rn)             //Enqueue
{

node *temp,*ptr;
//Enquing

temp=new node(rn,nam);
ptr=l1.head;
while(ptr->next!=NULL)
{
ptr=ptr->next;
}
ptr->next=temp;
}

void Queue::Dequeue()           //Dequeue
{
front=front+1;
l2.head=l2.head->next;
}

void Queue::Withdraw(int g)                  //Withdraw Admission
{
	node *ptr,*temp;
	ptr=l1.head;
	while(ptr->next->no!=g)
	{
	  ptr=ptr->next;
	}
    temp=ptr->next;
	ptr->next=ptr->next->next;
	delete(temp);
}
void Queue::Display_Admittedlist()        //Display Admittedlist
{
//Sorting AdmittedList-Bubblesort

node *ptr;
ptr=l1.head;
cout<<"\n*********Admitted List*********"<<endl;
   while(ptr!=NULL)
{
  cout<<"Cet Score"<<ptr->no<<"\tName:"<<ptr->content<<endl;
  ptr=ptr->next;
}

}

void Queue::hardcode_waitinglist()
{

node *temp,*ptr;

     int i1,i2,i3,i4;

string str1,str2,str3,str4;

i1=146;
i2=172;
i3=152;
i4=147;

str1="Ron weasely";
str2="Harry Potter";
str3="Harmonie Granger";
str4="Willy Thomason";

temp=new node(i1,str1);
l2.head=temp;
ptr=l2.head;
temp=new node(i2,str2);
ptr->next=temp;

ptr=ptr->next;
temp=new node(i3,str3);
ptr->next=temp;

ptr=ptr->next;
temp=new node(i4,str4);
ptr->next=temp;


}
void Queue::Display_waitinglist()        //Display Queue of waiting list
{
node *ptr;
ptr=l2.head;
cout<<"\n********Waiting List*******"<<endl;
   while(ptr!=NULL)
{
  cout<<"Cet Score"<<ptr->no<<"\tName:"<<ptr->content<<endl;
  ptr=ptr->next;
}
}
void news_display(int ch)         //News Display Function
{
     linkedlist l;
int i1,i2,i3;
node *temp,*ptr;
string str1,str2,str3;

i1=1;
i2=2;
i3=3;
str1="Ranked 44th\n\tStarted by MKSSS in 1991, The Cummins College of Engineering for Womens\n\tAbout MKSSSmksssOur founder Bharat Ratna Maharshi Dhondo Keshav Karve sowed the seeds\nVision\nTo be globally renowned institute for imparting quality education and to develop women leaders in engineering and technology.\nMission\nTo develop women professionals who are academically & technically competent  with strong professional ethics....\n\t Library Information \nThe Library of College was established in 1991. It serves to the College staff as well as students. It supports the academic activities of the College. Patrons can use more than 58727 books, national and international journals. The central Library has Stack section, Periodicals section, Reference section and Reading Hall. All students have open access in all sections of Library. The Library uses SLIM 21 software. It consists of Acquisition, Catal..oging, Circulation, Serials control and Web OPAC. Barcode based circulation of books is practised. Book club is very active in college.";
str2="**NBA accrediation**\n The courses are accredited by NBA in 1998,2002 ,2006,2012,2017,2018\n1:ENTC department Accredited in**2018**&vaild up to ***30/6/21***\n2:IT department Accredited in**2018**&vaild up to***30/6/21***\n 3:MECH department Accredited in**2016**&vaild upto ***30/6/19***\n4:CoMP deparment Accredited by NBA  in **1998,2002,2006,2012**\n5: INSTRU department Accredited byNBA in **1998,2002,2006,2012**";
str3="Robocon team \t  \nIt is a robotic contest organized by Asia-Pacific Broadcasting Union (ABU), a collection of over 20 countries of Asia Pacific Region. The robot is conceptualized, designed, analyzes, tested, manufactured, fabricated and run by the students\t \n    The Robotics Journey Of the Cummins College Of Engineering...\n  \t  TEAM AAVEG 2018• TEAM AAVEG is the official Robocon team of the Cummins College of Engineering,Pune• Awarded with the Best Women's Team in 2015   \t  \nABU Robocon is an Asia wide competition organized by the ASIA PACIFIC BROADCASTING UNION, each year. This year's theme was CLEAN ENERGY RECHARGES THE WORLD, The host country was THAILAND.\n \t          National Event: ROBOCON \n \tIt is an international robotics contest founded by Asia Pacific Broadcasting Union (ABU) in 2002. \n \t Eighteen Asia Pacific countries participate in this contest. Host country decides the task and rules of the competition every year.\n \t The Institute team is participating in this event since year 2011-12.\n \t In 2014-15, the Institute team won Best Women Team award. ";

temp=new node(i1,str1);
l.head=temp;
ptr=l.head;
temp=new node(i2,str2);
ptr->next=temp;

ptr=ptr->next;
temp=new node(i3,str3);
ptr->next=temp;

//Display

  ptr=l.head;
  while(ptr->no!=ch)
  {
  ptr=ptr->next;
  }
  cout<<ptr->content;
}
void result()           //Result Function
{
string str[5];
  int i,r,ans;
  str[0]=" roll no 1 \n ppl=50 \t dsa=60 \t  pef= 80 \t  cgpa=6.6  \t  percentage=63.33";
  str[1]="roll  no 2 \n ppl=60 \t dsa=50 \t pef=90 \t cgpa=7.01  \t percentage=66.66";
  str[2]="roll no 3 \n ppl=75  \t dsa=70 \t ppl=75 \t pef= 82  \t cgpa=7.96  \t percentage=75.66";
  str[3]="roll no 4 \n ppl=60 \t dsa= 80 \t pef=90 \t cgpa=8.06 \t percentage=76.66";
  str[4]="roll no 5 \n ppl=80 \t dsa=85 \t pef=90 \t cgpa=8.94 \t percentage=85";
  do
  {

  cout<<" \n \t go to results  ? if yes press 1";

  cin>>ans;

  if(ans==1)
  {
  cout<<"\n \t note : enter roll no between 1 to 5";
  cout<<" \n enter rollno whose result u want";
  cin>>r;

  for(i=0;i<5;i++)
   {

      if(r-1==i)
    {
  cout<<str[i];
     }
  }

  }

  }while(ans==1);
}
void contact_us(int q)          //Contact Us Function
{
string s[5];
s[1]="\n\tPrincipal's no\n\t9846748374";
s[2]="\n\tOffice no\n\t0202547564";
s[3]="\n\tEmailID:\n\tprincipal@cumminscollege.org";
cout<<s[q];
}

void upcoming_events(int w)       //Upcoming Events
{

node *temp,*ptr;
string name;
int rn;
string s2="*******Innovation********";

             //Innovation


cout<<s2<<endl;


cout<<"Enter your name"<<endl;
cin>>name;
cout<<"Enter your Rollno"<<endl;
cin>>rn;
temp=new node(rn,name);
if(l1.head==NULL)
{
  l1.head=temp;

}
else
{
   ptr=l1.head;
   while(ptr->next!=NULL)
   {
     ptr=ptr->next;
   }
   ptr->next=temp;

}



cout<<"*******List of Registered students are*********:\n"<<endl;


  ptr=l1.head;
  while(ptr!=NULL)
  {
  cout<<"Name:"<<ptr->content<<"\nRollno:"<<ptr->no<<endl;
  cout<<"\n";
  ptr=ptr->next;
  }
}

void notice(int ch)            //Notoce Board Function
{
	 linkedlist l;
	 int i1,i2,i3;
	 node *temp,*ptr;
	 string str1,str2,str3;

	 i1=1;
	 i2=2;
	 i3=3;
	 str1="\n \tAll students should register themselves for the scholarship on the new site www.mah.com \n \t for any queries related to application registration contact scholarship department head mrs ananya sharma\n";
	 str3="\n \tThe selections of college cricketing team to be held on monday i.e 8/8/18 \n \t all the students need to be in their sports uniform with cricket kit \n";
	 str2="\n \tFor carrier counselling and job opportunities contact head registrar mr mohak pandey\n ";
	 temp=new node(i1,str1);
	 l.head=temp;
	 ptr=l.head;
	 temp=new node(i2,str2);
	 ptr->next=temp;

	 ptr=ptr->next;
	 temp=new node(i3,str3);
	 ptr->next=temp;

	//Display

  ptr=l.head;
  while(ptr->no!=ch)
  {
  ptr=ptr->next;
  }
  cout<<ptr->content;
}

int main()
{
linkedlist l;
Queue q,q1,q2,q3,q4,q5;
stack s;
string str1,str2,str3,str4,nam;
  string str10="**************Welcome to Cummins college of Engineering for Women*************\n\n\n\tAn Autonomous Institute affliated to SPPU";
  cout<<str10;
  do
  {
  cout<<"\n\t1.Student Zone"<<endl;
  cout<<"\t2.Notice Board"<<endl;
  cout<<"\t3.News"<<endl;
  cout<<"\t4.Upcoming Events"<<endl;
  cout<<"\t5.Contact us"<<endl;
  int ch,ch1;
  cout<<"\n\t\tEnter your Choice:";
  cin>>ch;
  switch(ch)  //1st switch case open
  {
  case 1:  //Student Zone
  cout<<"\n************Student Zone**********"<<endl;
  do     //1st do while
  {
  cout<<"\n\t1.Admission"<<endl;
  cout<<"\t2.Result Portal"<<endl;
  cout<<"\t3.Downloads"<<endl;
  cout<<"\t4.Placement"<<endl;
  cout<<"\t5.Alumnae"<<endl;
  cout<<"\t6.Back to previous Page"<<endl;
  cout<<"\n\tEnter your Choice"<<endl;

  cin>>ch1;
  int ch4,c;
  switch(ch1)   //2nd switch case open
  {
  case 1:  //Admission
  q.hardcode_list();
  q1.hardcode_waitinglist();
      do
      {
      cout<<"\n*********Admission********"<<endl;
      cout<<"1.Display List of Admitted Candidate"<<endl;
      cout<<"2.Display Waiting List"<<endl;
      cout<<"3.Withdraw Admission"<<endl;
      cout<<"4.Back to Previous Page"<<endl;
      cout<<"\n\tEnter Your Choice"<<endl;
      cin>>ch4;
      switch(ch4)
      {
      case 1:
      q1.Display_Admittedlist();
      break;

      case 2:
      q2.Display_waitinglist();
      break;

      case 3:  //WithDraw Admission
      int r;
      cout<<"Enter your CET score:"<<endl;
      cin>>r;
      q3.Withdraw(r);
      q4.Enqueue(l2.head->content,l2.head->no);
      q5.Dequeue();
      }

      }while(ch4!=4);
  break;

  case 2:   //Result
  result();
  break;


  case 3:
  // Downloads start
  cout<<"\n Academic calender";
  cout<<"\n1.Academic information of 1st year"<<endl;
  cout<<"\n2.academic information of 2nd year"<<endl;
  cout<<"\n3.Academic information of 3rd year"<<endl;
  cout<<"\n4.Academic information of 4th year"<<endl;
  cout<<"\n 5. display result"<<endl;
  cout<<"\n enter your choice";
  cin>>ch;
  switch(ch)   //3rd switch case open
  {
  case 1:    //Academic Calendar of 1st yr
  cout<<"\n Academic calender of 1st year";
  cout<<"\n 1aug-15 nov"<<"\t first sem"<<endl;
  cout<<"\n 1sep-8sep"<<"\t midsem exam"<<endl;
  cout<<"\n 15 dec-27 apl"<<"\t second sem"<<endl;
  cout<<"\n 10 may-25 may"<<"\t reexam"<<endl;
  cout<<"\n*****syllabus*****"<<endl;
  cout<<"\nMATHEMATICS";
  cout<<"\n complex number \n calculas of one variable \n linear algebra \n ordinary differential equation"<<endl;
  cout<<"\n textbook-"<<"\t RAMANA"<<endl;
  cout<<"\n PHYSICS"<<endl;
  cout<<"\n interference of light \n diffraction \n polarization \n mechanics";
  cout<<"\n textbook-"<<"\tFEYNMAN";
  cout<<"\n*******timetable***";
  cout<<"\n 8-9am"<<"\tmath"<<"\t prof.purandare" <<endl;
  cout<<"\n 9-10am"<<"\t phy"<<"\t prof.vikram"<<endl;
  cout<<"\n 10-10:15"<<"\t break"<<endl;
  cout<<"\n 11-12pm"<<"\t chem"<<"\t prof.swapnali";
      break;
  case 2: //Academic Calendar of 2nd yr
  cout<<"\n*****Academic calender of 2nd year"<<endl;
  cout<<"\n 15 aug-27 aug"<<"\t midsem exam"<<endl;
  cout<<"\n 3 nov 28 nov"<<"\t endsem exam"<<endl;
  cout<<"\n 12 dec-16 dec"<<"\t GANDHAR event"<<endl;
  cout<<"\n 30 apl -25 may"<<"\t summar vacation"<<endl;
  cout<<"\n ******syllabus****"<<endl;
  cout<<"\n DISCRETE MATHEMATICS"<<endl;
  cout<<"\n sets \n permutation & combination \n graphs \n relation & function"<<endl;
  cout<<"\n textbook"<<"\tLIU"<<endl;
  cout<<"\n DATA STRUCTURE AND ALGORITHM";
  cout<<"\n linked list \n stack \n queue \n sorting"<<endl;
  cout<<"\n textbook-"<<"\t sahani mehta"<<endl;
  cout<<"\n DSCO"<<endl;
  cout<<"\n digital system \n computer organisation \n basic electronics"<<endl;
  cout<<"\n textbook"<<"\t william stallings"<<endl;
  cout<<"****timetable****"<<endl;
  cout<<"\n 8-9am"<<"\tDM"<<"\t prof.naik"<<endl;
  cout<<"\n 9-10am"<<"\t DSCO"<<"\t prof.madhuri";
  cout<<"\n 10:10:30 am"<<"\t break"<<endl;
  cout<<"\n 11-12pm"<<"\t DSA"<<"\t prof.rajashree"<<endl;
  break;

  case 3:   //Academic Calendar of 1st yr
  cout<<"\n ****Academic calender of 3rd year"<<endl;
  cout<<"\n 15 jul-15 nov"<<"\t first sem"<<endl;
  cout<<"\n 12 aug -16 aug"<<"\t t1 exam"<<endl;
  cout<<"\n 15 oct -30 oct"<<"\t endsem exam"<<endl;
  cout<<"\n 30 oct -15 nov"<<"\t diwali vacation"<<endl;
  cout<<"15 may -15 jun"<<"\t summar vacation"<<endl;
  cout<<"\n *******syllabus****"<<endl;
  cout<<"\n the 3rd year computer engineering course trains in core areas such as databases, software engineering processes,computer network,system prpgramming and microprocessor-microcontrolller theory and interfacing.it also introduces the software development tools and web technology"<<endl;
  cout<<"\n*******timetable******"<<endl;
  cout<<"\n 8-10 am"<<"\t dsa lab"<<endl;
  cout<<"\n 10-12pm"<<"\t web development"<<endl;
  cout<<"\n 2-4pm"<<"\t microprocessor 7microcontroller"<<endl;
  break;

  case 4:    //Academic Calendar of 1st yr
  cout<<"\n ****academic calender of 4th year"<<endl;
  cout<<"\n 1jul-15 aug"<<"\t project"<<endl;
  cout<<"\n 1sep-20 sep"<<"\t online exam"<<endl;
  cout<<"\n 2 oct-30 oct"<<"\t aptitude test round"<<endl;
  cout<<"\n 4 nov -1dec"<<"\t interviews"<<endl;
  cout<<"\n ********syllabus*****";
  cout<<"\n the final year engineering course allows the students to implement the design idea into a working model with necessary software interface with the help of project work,which span for 1 academic year"<<endl;
  break;
  }//3rd switch case closed
      break;
      //Download ends

  case 5:     //Alumnae
   cout<<"\n alumnae";


  str1=" \n \t Gayatri Adi – Amongst the first graduate students from the Cummins College of Engineering for Women in Pune , currently holds a research position with Cummins inc ,USA  \n \t ";

   str2=" \n \t Rajashree Karwa – founder of Velvet Aroma \n \t Sonia Chawdhary - founder of Velvet Aroma";

   str3=" \n \t Renuka Gregg-  She is also an alumnus of University of Pennsylvania - The Wharton School she is currently Currently the Lead Product Manager at Microsoft \n \t \n \t Neha Bhaskar- She is also an alumus of Yale School of ManagementCurrently the Marketing Manager at microsoft \n \t ";
  str4="\n \t  first batch alumna mrs urmila menon is currently working as vice president at allied universal security california \n \t ";
   cout<<str1;
   cout<<str2;
  cout<<str3;

  cout<<str4;
  break;

  case 4:   //Placement
 	  do{
 	     cout<<"\n **** placement of cummins******";
 	     cout<<"\n1.year 2016-17\n2.2018\n3.exit";

 	     cout<<"\n enter your choice to see the placement of cummins college of engg";
 	        cin >>c;
 	     switch(c)
 	     {
 	           case 1:
 	           cout<<"\n**year 2016-17**\n placement of cummins for group 1(i.e salary above INR 6 Lakhs)is 104 \n and for group 2 (i.e salary belowe 6 lakhs )is300 ** total placement in this year is 404 ***\n highest salary affered in this year is:\n  1 .AMAZON   for  2 student and package is ₹ 17.75 lakhs\n2. CITI for 4 student is ₹13.25 lakhs \n 3.CISCO for 7 student is ₹ 13 lakhs";
 	           break;
 	           case 2:
 	           cout<<"\n ***year 2018***\nplacement for group 1 is 153 and group 2 is 285 \n ****total placement in this year is438\n the highst package offered in this year is :\n1.SALESFORCE for 1 gril is ₹ 30 lakhs\n2.Goldman sachs offered 20 lakhs for 2 students";
 	           break;
 	     case 3: cout<<" exit";
 	           break;
          }
 	     //2nd switch case closed
   }while(c!=3);
   break;
   }
  }while(ch1!=6);
    break;

  case 2:  //Notice Board
	  do
	  {
	  cout<<"\n\t****************Notice Board**************"<<endl;
	  cout<<"\n\t1.Apply for Scholarship"<<endl;
	  cout<<"\t2.Counselling is available...Register"<<endl;
	  cout<<"\t3.Slection for Cricket...register "<<endl;
	  cout<<"\t4.Back to previous Page"<<endl;
	 	  	  cin>>ch;
	 	  	  if(ch!=4)
	 	  	  notice(ch);
	  }while(ch!=4);
	 	  	break;
  case 3:        //News

  do
  {
   cout<<"**************News***************"<<endl;
   cout<<"1.Cummins Ranked 44th in Maxizine Survey of Top 100Engineering Colleges"<<endl;
   cout<<"2.Mech and EnTC departement was accrediated by NBA"<<endl;
   cout<<"3.College's Robocon Team ranked 31st in National"<<endl;
   cout<<"4.Back to previous seen news"<<endl;
   cout<<"5.Back to Home"<<endl;
   cout<<"\nEnter Achievement number to know more..."<<endl;
   cin>>ch;
   s.push(ch,50);
   cout<<"\n\n";

  if(ch==1||ch==2||ch==3)
  news_display(ch);
  if(ch==4)
  {
	s.pop();
	s.pop();
	int e=s.pop();
 news_display(e);
  }
  if(ch!=5)
  cout<<"\n\n";

  }while(ch!=5);
  break;

  case 4:           //Upcoming Event
  cout<<"\n\t\t\t**********Upcoming Events************"<<endl;
  int w;
  do
  {
  cout<<"\n\t\t\t1.Click to Register in Innovation"<<endl;
  cout<<"\t\t\t2.Back to Previous Page"<<endl;
  cout<<"Enter your choice"<<endl;
  cin>>w;
  if(w!=2)
  upcoming_events(w);
  }while(w!=2);

  break;
  case 5:         //Contact Us
  string st="*********Contact Us***********";

  int q;
  do
  {
  cout<<"\n\t\t\t"+st<<endl;
  cout<<"\n\t\t\t1.Principal no-"<<endl;
  cout<<"\t\t\t2.Office no-"<<endl;
  cout<<"\t\t\t3.Email ID-"<<endl;
  cout<<"\t\t\t4.Back to Previous Page"<<endl;
  cout<<"\n\tEnter your Choice:"<<endl;

  cin>>q;
  if(q!=4)
  contact_us(q);

  }while(q!=4);
  break;

  }
//1st switch case closed
}while(true);
}
