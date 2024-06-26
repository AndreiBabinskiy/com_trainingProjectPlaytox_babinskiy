# com_trainingProjectPlaytox_babinskiy
<h3>Требования</h3>
<h4>Общие требования</h4>
<ul>
<li>Архитектура - Java SE 8.0 (или выше), использование библиотек и фреймворков на усмотрение исполнителя.</li>
<li>Должна быть система логирования (на основе готового решения, например Log4j). Приложение должно логировать в файл любые действия, приводящие к изменению данных. Приложение должно корректно обрабатывать и логировать ошибки.</li>
</ul>
<h4>Структура данных</h4>
<h5>В приложении должна быть сущность Account (счет) содержащая поля:</h5>
<ul>
<li>ID (строковое) - идентификатор счета</li>
<li>Money (целочисленное) - сумма средств на счете</li>
</ul>
<h4>Функциональные требования</h4>
<ul>
  
</ul>
<li>При запуске приложение должно создать четыре (или более) экземпляров объекта Account со случайными значениями ID и значениями money равным 10000.</li>
<li>В приложении запускается несколько (не менее двух) независимых потоков. Потоки должны просыпаться каждые 1000-2000 мс. Время на которое засыпает поток выбирается случайно при каждом исполнении.</li>
<li>Потоки должны выполнять перевод средств с одного счета на другой. Сумма списания или зачисления определяется случайным образом. Поле money не должно становиться отрицательным, сумма money на всех счетах не должна меняться.</li>
<li>Решение должно быть масштабируемым по количеству счетов и потоков и обеспечивать возможность одновременного (параллельного) перевода средств со счета a1 на счет a2 и со счета a3 на счет а4 в разных потоках.
<li>Результаты всех транзакций должны записываться в лог.</li>
<li>После 30 выполненных транзакций приложение должно завершиться.</li>
