package com.Application;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int nr = 0;
        boolean flag1=true;
        boolean flagReg = true;
        Register[] Angajati = new Register[nr];
        System.out.println("Bine a-ti venit!");
        while (flag1)
        {
            System.out.println("     ***MENU***");
            System.out.println("     1.Register Employee");
            System.out.println("     2.View Employees");
            System.out.println("     3.Edit Employee");
            System.out.println("     4.Delete Employees");
            System.out.println("     0. - Exit!");
            System.out.println("     Press the number for the desired command: ");

            Scanner sc = new Scanner(System.in);
            switch(sc.nextLine())
            {
                case "1":
                    if (flagReg)
                    {
                        System.out.println("Ai ales Registering!");
                        System.out.println("Enter nr angajati: ");

                        nr = sc.nextInt();
                        String rest = sc.nextLine();
                        Angajati = new Register[nr];

                        for (int i=0; i<nr; i++)
                        {
                            System.out.println("Enter nume: ");
                            String nume = sc.nextLine();
                            System.out.println("Enter prenume: ");
                            String prenume = sc.nextLine();
                            System.out.println("Enter profesia: ");
                            String titlu = sc.nextLine();
                            Angajati[i] = new Register(nume, prenume, titlu);
                        }
                        System.out.println("Angajatul(ii) a/au fost inregistrat(i) cu succes!");
                        flagReg=false;
                        break;
                    }
                    else{
                        System.out.println("Angajatii deja au fost Inregistrati!");
                        break;
                    }

                case "2": System.out.println("A-ti ales Afisare!");
                    if (nr >0) {
                        System.out.println("Pentru a vizualiza toti angajatii apasa '1'");
                        System.out.println("Pentru a vizualiza un angajat specific apasa '2'");

                        Scanner Raspuns = new Scanner(System.in);
                        switch (Raspuns.nextLine()) {
                            case "1":
                                for (int i = 0; i < nr; i++) {
                                    System.out.println(i + 1 + "Nume: " + Angajati[i].getName());
                                    System.out.println("Prenume: " + Angajati[i].getSurname());
                                    System.out.println("Profesia: " + Angajati[i].getTitle());
                                    System.out.println(" ");

                                }
                                break;
                            case "2":
                                try{
                                    System.out.println("Indica ID-ul (Numarul angajatului pe care doresti sa il afisezi: ");
                                    int ID_Dorit = Raspuns.nextInt()-1;
                                    System.out.println(". Nume: " + Angajati[ID_Dorit].getName());
                                    System.out.println("Prenume: " + Angajati[ID_Dorit].getSurname());
                                    System.out.println("Profesia: " + Angajati[ID_Dorit].getTitle());
                                    System.out.println(" ");
                                    break;
                                }
                               catch(ArrayIndexOutOfBoundsException ex)
                               {
                                   System.out.println("Nu exista angajat cu asemenea ID!");
                               }
                                catch(Exception e)
                            {
                                System.out.println("Introduceti va rog caractere numerice!");
                            }
                            default:
                                System.out.println("Optiunea aleasa este indisponibila!");
                        }
                    }
                    else
                    {
                        System.out.println("Nu sunt angajati de afisat!");
                    }
                    break;

                case "3":System.out.println("Ai ales Edit!");
                    if (nr >0)
                    {
                        System.out.println("Introdu ID-ul (numarul) angajatului care doresti sa il modifici: ");
                        int ID = sc.nextInt()-1;
                        String rest = sc.nextLine();
                        System.out.println("Re-introdu numele: ");
                        String nume = sc.nextLine();
                        System.out.println("Re-introdu prenumele: ");
                        String prenume = sc.nextLine();
                        System.out.println("Re-introdu profesia: ");
                        String titlu = sc.nextLine();
                        Angajati[ID] = new Register(nume, prenume, titlu);
                    }

                    else{System.out.println("Nu sunt angajati de editat!");}
                    break;

                case "4":System.out.println("Ai ales Delete");
                    if (nr >0)
                    {
                        System.out.println("Introdu ID-ul (numarul) angajatului care doresti sa il stergi: ");
                        int ID = sc.nextInt()-1;
                        String rest = sc.nextLine();

                        if(ID<nr)
                        {
                            for (int i=ID; i<Angajati.length-1; i++) //sau i<nr-1
                            {
                                Angajati[i]=Angajati[i+1];
                            }
                            Angajati[nr-1]=new  Register("", "", "");
                        }
                        else{
                            System.out.println("Invalid ID!");
                            break;
                        }
                    }

                    else{System.out.println("Nu sunt angajati de sters!");}
                    break;

                case "0":System.out.println("Goodbye!"); flag1=false; break;
                default: System.out.println("Nu exista asa optiune! Goodbye!");  flag1=false; break;

            }
        }
    }
}