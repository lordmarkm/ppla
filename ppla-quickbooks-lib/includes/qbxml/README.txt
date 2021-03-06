## $Id: README.txt,v 1.1 2009/02/08 04:13:22 vauxia Exp $

These files list the available queries, entities and validation rules for
QBXML, based on the selected version of your API.  The Quickbooks module uses
these to generate and validate its queries for Quickbooks.

Most users should not need to make any changes to these files.  However, if
you must do so, please don't change these files manually!

The values of the functions returned are automatically generated by using 
the included script which parses the XSD files distributed by Intuit.  I was 
not able to find these XSD files generally available, but they do appear to
be hiding in a subfolder of the validator tool included in their SDK.

For a variety of reasons, I don't want to include the XSD files in this 
Drupal module.  Should you need to update the files in this directory or
generate files additional SDK versions, you should:

  1. Obtain an account at http://developer.intuit.com/
  2. Download the most current SDK ( e.g. the QBSDK70.exe self-extractor )
  3. Install it on a Windows machine (or virtual machine, if you're into that)
  4. Find the *.xsd files from the Validator utility's directory 
     ( e.g. C:\Program Files\Intuit\IDN\Common\tools\validator )
  5. Copy those XSD files into this directory so that the included parsing 
     script can find them.
  6. From a command line, run "qbxml.php", which will generate all of the 
     qbxml.*.inc files.

If the qbxml.php file must be changed, or if the result is updated or 
newly-added files, please submit a patch at http://drupal.org/project/qb

