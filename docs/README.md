# Útmutató a fájlokhoz

A `default-accounts.md` fájlban vannak a teszt felhasználók email címei és jelszavai. 

A vizsgakövetelmények az `exam-requirements.md` fájlban láthatóak.

A menedzsment számára a jelentés a `management-test-report.xlsx` fájlban van. 

A `manual-test-cases.md` fájlban található a részletes dokumentáció minden automata teszthez.

A `requirement-table.xls` fájlban található a táblázat, hogy melyik teszt melyik vizsga követelményt fedi le.

## Tesztesetek egyesével futtatásához 

./mvnw test -Dtest=RegistrationTest#successfulRegistrationTest

./mvnw test -Dtest=RegistrationTest#unsuccessfulRegistrationTest

./mvnw test -Dtest=LoginTest#loginTest

./mvnw test -Dtest=PrivacyPolicyTest#checkPrivacyPolicyContainsTwoWordsTest

./mvnw test -Dtest=ProductListTest#productListTest

./mvnw test -Dtest=ProductListTest#checkProductNamesTest

./mvnw test -Dtest=ProductCategoryTest#listProductsAndTraverseCategories

./mvnw test -Dtest=ContactUsTest#contactUsSubmitForm

./mvnw test -Dtest=BulkRegistrationFromCsvTest#registerMultipleUsersFromCsv

./mvnw test -Dtest=ModifyCartItemQuantityTest#addProductChangeQuantityViaReadAndRemove

./mvnw test -Dtest=ExportProductNameAndTheirPrices#exportProductsToCsvTest

















