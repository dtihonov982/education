##Поиск информационных баз 1С: Предприятие в заданной директории и поддиректориях

##Можно загрузить список зарегистрированных ИБ с помощью процедуры load_ilist
##из стандартного файла вида *.v8i и сравнить со списком реально существующих.


import re, os
from os.path import isdir, isfile

def load_ilist():
    pattern = re.compile(r'File="(.+)"')
    file = open(u'list_db.v8i', 'r')
    result = []
    for line in file:
        m = pattern.search(line)
        if m:
            result.append(m.group(1))
    return result

def is_infobase(directory):
    p = re.compile('.*\.1[cC][Dd]')
    #print(directory)
    for i in os.listdir(directory):
        if p.search(i):
            return True
    return False

def dirs_list(top):
    _alllist = os.listdir(top)
    alllist = map(lambda x: os.path.join(top, x), _alllist)
    res = filter(isdir, alllist)
    return list(res)

def search_infobases(top, pass_list=[]):
    queue = dirs_list(top)
    result = []
    errors = []
    for d in queue:
        
        if d in pass_list:
            continue
        
        try:
            if is_infobase(d):
                result.append(d)
            else:
                queue.extend(dirs_list(d))
        except:
            errors.append('###Неизвестная ошибка. Каталог ' + d)
            
    return (result, errors)

def lprint(L):
    for i in L:
        print(i)           
        
def main(err_mode=False):
    main_dir = input('Введите имя директории, в которой будет вестись поиск\n> ')   
    try:
        result, errors = search_infobases(main_dir, std_pass_list)
        for ib in result:
            print(ib)

        if err_mode:
            for e in errors:
                print(e)
    except:
        print('Неизвестная ошибка')    

std_pass_list = [r'C:\Windows', r'C:\Program Files', r'C:\Program Files (x86)', r'C:\$Recycle.Bin']