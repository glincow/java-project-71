# Учебный проект "Вычислитель отличий"

### Hexlet tests and linter status:
[![Actions Status](https://github.com/glincow/java-project-71/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/glincow/java-project-71/actions)

### Sonar status
[![Java CI](https://github.com/glincow/java-project-71/actions/workflows/build.yml/badge.svg)](https://github.com/glincow/java-project-71/actions/workflows/build.yml)[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=glincow_java-project-71&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=glincow_java-project-71) [![Code Smells](https://sonarcloud.io/api/project_badges/measure?project=glincow_java-project-71&metric=code_smells)](https://sonarcloud.io/summary/new_code?id=glincow_java-project-71)[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=glincow_java-project-71&metric=coverage)](https://sonarcloud.io/summary/new_code?id=glincow_java-project-71)[![Duplicated Lines (%)](https://sonarcloud.io/api/project_badges/measure?project=glincow_java-project-71&metric=duplicated_lines_density)](https://sonarcloud.io/summary/new_code?id=glincow_java-project-71)


### Описание

Вычислитель отличий – программа, определяющая разницу между двумя структурами данных. Это популярная задача, для решения которой существует множество онлайн сервисов, например http://www.jsondiff.com/. Подобный механизм используется при выводе тестов или при автоматическом отслеживании изменении в конфигурационных файлах.

## Возможности утилиты:

Поддержка разных входных форматов: `yaml`, `json`.

Генерация отчета в виде `stylish`, `plain text` и `json`.

## Установка
```
make install
```
## Запуск тестов
```
make test
```
```
make test-coverage
```

## Пример использования
```bash
gendiff -h
Usage: gendiff [options] <filepath1> <filepath2>

Compares two configuration files and shows a difference.

Arguments:
  filepath1            relative or absolute path to the file
  filepath2            relative or absolute path to the file

Options:
  -V, --version        output the version number
  -f, --format <type>  output format
  -h, --help           display help for command
```

Формат: `stylish` (по умолчанию)
```bash
gendiff filepath1.json filepath2.json

{
  + follow: false
    setting1: Value 1
  - setting2: 200
  - setting3: true
  + setting3: {
        key: value
    }
  + setting4: blah blah
  + setting5: {
        key5: value5
    }
}

```
[![asciicast](https://asciinema.org/a/MxI1jz1SuZhjmhXq8MfnLU5Ca.svg)](https://asciinema.org/a/MxI1jz1SuZhjmhXq8MfnLU5Ca)

Формат: `plain`
```bash
gendiff --format plain path/to/file.yml another/path/file.json

Property 'common.follow' was added with value: false
Property 'group1.baz' was updated. From 'bas' to 'bars'
Property 'group2' was removed

```

[![asciicast](https://asciinema.org/a/LmE6IU1TE75VE3fQXtoF4aUlv.svg)](https://asciinema.org/a/LmE6IU1TE75VE3fQXtoF4aUlv)

Формат: `json`
```bash
gendiff --format json __fixtures__/file1.json __fixtures__/file2.json

[{"key":"common","state":"nested","value":[{"key":"follow","state":"added","value":false},{"key":"setting1","state":"notChanged","value":"Value 1"},{"key":"setting2","state":"deleted","value":200},{"key":"setting3","state":"changed","value1":true,"value2":null},{"key":"setting4","state":"added","value":"blah blah"},{"key":"setting5","state":"added","value":{"key5":"value5"}},{"key":"setting6","state":"nested","value":[{"key":"doge","state":"nested","value":[{"key":"wow","state":"changed","value1":"","value2":"so much"}]},{"key":"key","state":"notChanged","value":"value"},{"key":"ops","state":"added","value":"vops"}]}]},{"key":"group1","state":"nested","value":[{"key":"baz","state":"changed","value1":"bas","value2":"bars"},{"key":"foo","state":"notChanged","value":"bar"},{"key":"nest","state":"changed","value1":{"key":"value"},"value2":"str"}]},{"key":"group2","state":"deleted","value":{"abc":12345,"deep":{"id":45}}},{"key":"group3","state":"added","value":{"deep":{"id":{"number":45}},"fee":100500}}]

```
[![asciicast](https://asciinema.org/a/kfbw3a6upd9yxUwNIeUjNAh27.svg)](https://asciinema.org/a/kfbw3a6upd9yxUwNIeUjNAh27)




