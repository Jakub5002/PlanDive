# 1. Jako Instruktor, chcę widzieć swój harmonogram zajęć w formie kalendarza, aby móc organizować swój czas prywatny i pracę.

## Kryteria akceptacyjne

1. Instruktor może otworzyć widok kalendarza po zalogowaniu.
2. Kalendarz pokazuje wyłącznie zajęcia przypisane do instruktora.
3. Dostępne są widoki dzienny, tygodniowy i miesięczny (domyślnie tygodniowy).
4. Zajęcia zawierają nazwę kursu, datę, godzinę i status.
5. System pokazuje komunikat o braku zajęć w danym dniu.

## Scenariusze testowe

### Scenariusz 1 — Wyświetlenie harmonogramu

**Given:** instruktor jest zalogowany

**When:** otwiera moduł harmonogramu

**Then:** system wyświetla kalendarz z jego zajęciami


### Scenariusz 2 — Zmiana widoku kalendarza

**Given:** instruktor przegląda harmonogram

**When:** wybiera widok miesięczny

**Then:** system wyświetla kalendarz miesięczny


### Scenariusz 3 — Brak zajęć

**Given:** instruktor nie ma zaplanowanych zajęć

**When:** otwiera kalendarz

**Then:** system wyświetla komunikat „Brak zaplanowanych zajęć”



# 2. Jako Instruktor, chcę mieć możliwość zgłoszenia dni wolnych lub niedostępności, aby koordynator nie przypisywał mi wtedy kursów.

## Kryteria akceptacyjne

1. Instruktor może zgłosić dzień wolny.
2. Instruktor może określić zakres niedostępności.
3. System blokuje przypisywanie kursów w tym terminie.
4. Instruktor widzi zgłoszone niedostępności.
5. Instruktor może usunąć zgłoszenie.

## Scenariusze testowe

### Scenariusz 1 — Dodanie niedostępności

**Given:** instruktor jest zalogowany

**When:** dodaje dzień wolny

**Then:** system zapisuje niedostępność


### Scenariusz 2 — Blokada przypisania kursu

**Given:** instruktor zgłosił niedostępność

**When:** koordynator próbuje przypisać kurs

**Then:** system blokuje przypisanie


### Scenariusz 3 — Usunięcie niedostępności

**Given:** instruktor posiada zgłoszony dzień wolny

**When:** usuwa zgłoszenie

**Then:** termin ponownie staje się dostępny



# 2. Jako Instruktor, chcę widzieć listę kursantów przypisanych do moich zajęć wraz z ich stopniem nurkowym, aby wiedzieć, na jakim poziomie prowadzić szkolenie.

## Kryteria akceptacyjne

1. Instruktor może wyświetlić listę kursantów przypisanych do kursu.
2. Przy każdym kursancie widoczny jest poziom nurkowy.
3. Lista może być filtrowana po kursie.

## Scenariusze testowe

### Scenariusz 1 — Wyświetlenie listy kursantów

**Given:** instruktor prowadzi kurs

**When:** otwiera listę uczestników

**Then:** system wyświetla kursantów przypisanych do kursu


### Scenariusz 2 — Filtrowanie po kursie

**Given:** instruktor prowadzi kilka kursów

**When:** wybiera konkretny kurs

**Then:** system wyświetla tylko uczestników wybranego kursu



# 3. Jako instruktor, chcę generować raporty dotyczące zapisów i frekwencji kursantów, aby optymalizować wykorzystanie zasobów szkoły.

## Kryteria akceptacyjne

1. Instruktor może wygenerować raport frekwencji.
2. Raport zawiera obecności kursantów.
3. Raport można filtrować po kursie.
4. System umożliwia eksport raportu.

## Scenariusze testowe
      
### Scenariusz 1 — Generowanie raportu

**Given:** instruktor prowadzi kurs

**When:** wybiera opcję generowania raportu

**Then:** system tworzy raport frekwencji


### Scenariusz 2 — Filtrowanie raportu

**Given:** instruktor prowadzi kilka kursów

**When:** wybiera konkretny kurs

**Then:** raport zawiera dane tylko dla wybranego kursu


### Scenariusz 3 — Eksport raportu

**Given:** raport został wygenerowany

**When:** instruktor wybiera eksport

**Then:** system pobiera plik z raportem



# 4. Jako instruktor, chcę mieć możliwość przypisywania kursantów o odpowiednich kwalifikacjach do kursu

## Kryteria akceptacyjne

1. Instruktor może przypisać kursanta do kursu.
2. System sprawdza kwalifikacje kursanta.
3. Nieuprawniony kursant nie może zostać zapisany.
4. System wyświetla komunikat o błędzie przy braku kwalifikacji.

## Scenariusze testowe

### Scenariusz 1 — Poprawne przypisanie kursanta

**Given:** kursant posiada wymagane kwalifikacje

**When:** instruktor przypisuje go do kursu

**Then:** system zapisuje kursanta na kurs


### Scenariusz 2 — Brak kwalifikacji

**Given:** kursant nie posiada wymaganych kwalifikacji

**When:** instruktor próbuje przypisać go do kursu

**Then:** system wyświetla komunikat o braku uprawnień



# 5. Jako instruktor, chcę mieć możliwość odwołania zajęć w przypadku niekorzystnych warunków pogodowych, aby zapewnić bezpieczeństwo uczestników.

## Kryteria akceptacyjne

1. Instruktor może odwołać zajęcia.
2. System zapisuje powód odwołania.
3. Kursanci otrzymują powiadomienie o odwołaniu.
4. Status zajęć zmienia się na „Odwołane”.

## Scenariusze testowe

### Scenariusz 1 — Odwołanie zajęć

**Given:** instruktor prowadzi zajęcia

**When:** odwołuje je z powodu pogody

**Then:** system zmienia status zajęć na „Odwołane”


### Scenariusz 2 — Powiadomienie kursantów

**Given:** zajęcia zostały odwołane

**When:** system zapisze zmianę

**Then:** kursanci otrzymują powiadomienie



# 6. Jako kursant, chcę otrzymywać powiadomienia o zmianach lub odwołaniu zajęć, aby móc odpowiednio zmienić swoje plany.

## Kryteria akceptacyjne

1. Kursant otrzymuje powiadomienia o zmianie terminu zajęć.
2. Kursant otrzymuje powiadomienia o odwołaniu zajęć.
3. Powiadomienia zawierają datę, godzinę i nazwę kursu.
4. Powiadomienia są wysyłane automatycznie.
5. Kursant ma dostęp do historii powiadomień.

## Scenariusze testowe

### Scenariusz 1 — Zmiana terminu zajęć

**Given:** kursant jest zapisany na kurs

**When:** instruktor zmieni termin zajęć

**Then:** kursant otrzymuje powiadomienie o zmianie


### Scenariusz 2 — Odwołanie zajęć

**Given:** kursant jest zapisany na zajęcia

**When:** zajęcia zostaną odwołane

**Then:** system wysyła powiadomienie o odwołaniu


### Scenariusz 3 — Wyświetlenie historii powiadomień

**Given:** kursant otrzymał powiadomienia

**When:** otwiera sekcję powiadomień

**Then:** system wyświetla historię komunikatów



# 7. Jako instruktor, chcę mieć możliwość automatycznego powiadamiania kursantów i instruktorów o zmianach w harmonogramie, aby zredukować ilość ręcznych telefonów i maili.

## Kryteria akceptacyjne

1. System automatycznie wysyła powiadomienia o zmianach harmonogramu.
2. Powiadomienia trafiają do instruktorów i kursantów.
3. Powiadomienia zawierają szczegóły zmiany.
4. System zapisuje historię wysłanych powiadomień.

## Scenariusze testowe

### Scenariusz 1 — Zmiana harmonogramu

**Given:** użytkownik jest zapisany na zajęcia

**When:** harmonogram zostanie zmieniony

**Then:** system wysyła powiadomienie


### Scenariusz 2 — Historia powiadomień

**Given:** system wysłał powiadomienia

**When:** administrator otwiera historię powiadomień

**Then:** widzi listę wysłanych komunikatów i ich adresatów



# 8. Jako kursant, chcę móc zapisać się na wybrany kurs nurkowania online, aby nie musieć przychodzić osobiście ani dzwonić.

## Kryteria akceptacyjne

1. Kursant może przeglądać dostępne kursy.
2. Kursant może zapisać się online na kurs.
3. System potwierdza poprawny zapis.
4. System blokuje zapis na pełny kurs.
5. Kursant widzi status swojego zapisu.

## Scenariusze testowe

### Scenariusz 1 — Zapis na kurs

**Given:** kurs posiada wolne miejsca

**When:** kursant wybiera opcję zapisu

**Then:** system zapisuje kursanta na kurs


### Scenariusz 2 — Brak wolnych miejsc

**Given:** kurs jest pełny

**When:** kursant próbuje się zapisać

**Then:** system wyświetla komunikat o braku miejsc


### Scenariusz 3 — Potwierdzenie zapisu

**Given:** kursant został zapisany

**When:** operacja zakończy się sukcesem

**Then:** system wyświetla potwierdzenie zapisu



# 9. Jako kursant, chcę mieć dostęp do szczegółowych informacji o kursie i lokalizacji zajęć (basen, jezioro), aby przygotować się odpowiednio do zajęć.

## Kryteria akceptacyjne

1. Kursant może otworzyć szczegóły kursu.
2. System pokazuje opis kursu.
3. System pokazuje lokalizację zajęć.
4. System pokazuje prowadzącego zajęcia i kontakt do niego.
5. System wyświetla datę i godzinę zajęć.
6. Kursant może sprawdzić wymagania kursu.

## Scenariusze testowe

### Scenariusz 1 — Wyświetlenie szczegółów kursu

**Given:** kursant przegląda ofertę kursów

**When:** wybiera kurs

**Then:** system pokazuje szczegóły kursu



# 10. Jako kursant, chcę móc widzieć zapisane daty moich kursów w kalendarzu

## Kryteria akceptacyjne

1. Kursant może otworzyć kalendarz swoich kursów.
2. Kalendarz pokazuje wszystkie zapisane zajęcia.
3. Zajęcia zawierają datę i godzinę.
4. Kursant może przełączać widoki kalendarza.
5. System pokazuje komunikat o braku zapisanych kursów.
6. Kursant po kliknięciu jest przekierowywany do szczegółów danych zajęć.

## Scenariusze testowe

### Scenariusz 1 — Wyświetlenie kalendarza

**Given:** kursant jest zapisany na kursy

**When:** otwiera kalendarz

**Then:** system wyświetla jego zajęcia


### Scenariusz 2 — Widok szczegółów zajęć

**Given:** kursant przegląda kalendarz

**When:** wybiera zajęcia

**Then:** system pokazuje szczegółowe informacje (data, miejsce, prowadzący)


### Scenariusz 3 — Brak kursów

**Given:** kursant nie jest zapisany na żaden kurs

**When:** otwiera kalendarz

**Then:** system wyświetla komunikat „Brak kursów”



# 11. Jako właściciel chce, aby do kursów mogli zapisywać się kursanci z ważnymi badaniami lekarskimi

## Kryteria akceptacyjne

1. System zapisuje datę ważności badań lekarskich.
2. Kursant z nieważnymi badaniami nie może zapisać się na kurs.
4. Poprawny zapis jest możliwy tylko przy ważnych badaniach.

## Scenariusze testowe

### Scenariusz 1 — Zapis z ważnymi badaniami

**Given:** kursant posiada ważne badania

**When:** zapisuje się na kurs

**Then:** system umożliwia zapis


### Scenariusz 2 — Nieważne badania

**Given:** badania kursanta są nieważne

**When:** próbuje zapisać się na kurs

**Then:** system blokuje zapis

