## Описание приложения
Приложение "Мобильный хоспис" даёт функционал по работе с новостями хосписа и включает в себя:

* информацию о новостях и функционал для работы с ними;
* тематические цитаты;
* информацию о приложении.

## Настройка и запуск проекта (SUT)

1. Клонировать репозиторий через терминал командой - git clone git@github.com:IrinaSanna/DiplomQA.git
2. Открыть проект через Android Studio.
3. Запустить эмулятор Pixel 7 API 29.

## Запуск автотестов и формирование отчета

1. Открыть класс AuthorizationPageTest, AboutApplicationTest, ExitTheApplicationTest, NewsTest, QuoteDisplayTest:
* нажимать кнопку Run для каждого теста;
* либо выполнить команду в терминале ./gradlew connectedAndroidTest
2. Для формирования allure-отчета, необходимо в терминале выполнить команду allure serve