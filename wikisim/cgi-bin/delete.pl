#!"C:\xampp\perl\bin\perl.exe"
use strict;
use warnings;
use CGI;
use CGI::Carp qw(fatalsToBrowser);
use DBI;

my $cgi = CGI->new;
print $cgi->header;

my $id = $cgi->param('id');
my $dbh = DBI->connect("dbi:SQLite:dbname=db/BaseDeDatos.db", "admin", "admin");
my $sth = $dbh->prepare("DELETE FROM Articles WHERE id = ?");
$sth->execute($id);

$dbh->disconnect;

print $cgi->redirect('/cgi-bin/list.pl');
