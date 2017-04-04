import sendToQue

class Error(Exception):
    """Base class for other exceptions"""
    pass


class ValueTooSmallError(Error):
    """Raised when the input value is too small"""
    pass


class ValueTooLargeError(Error):
    """Raised when the input value is too large"""
    pass


class NotNumberException(Error):
    """Raised when the input value is not integer"""
    pass


class NameException(Error):
    """Raised when name is empty"""
    pass


class DesignerException(Error):
    """Raised when designer is empty"""
    pass


class AllMandatoryException(Error):
    """Raised when all fields are empty"""
    pass


def CheckYear(year):
    try:
        if not year.isdigit():
            raise NotNumberException
        if int(year) < 1900:
            raise ValueTooSmallError
        if int(year) > 2017:
            raise ValueTooLargeError
    except ValueTooSmallError:
        sendToQue.sendErrorToQue('yearTooSmall')
        return ''
    except ValueTooLargeError:
        return 'yearTooBig'
    except NotNumberException:
        return 'yearNotNumber'
    return 'OK'


def checkAllMandatory(name, designer, year):
    try:
        if year == '' and name == '' and designer == '':
            raise AllMandatoryException
    except AllMandatoryException:
        return 'allFieldsMandatory'
    yearResult = CheckYear(year)
    if not yearResult == 'OK':
        return yearResult
    try:
        if name == '':
            raise NameException
        if designer == '':
            raise DesignerException
    except NameException:
        return 'nameIsMandatory'
    except DesignerException:
        return 'designerIsMandatory'
