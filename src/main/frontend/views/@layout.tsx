import { effect, signal } from '@vaadin/hilla-react-signals';
import { AppLayout, DrawerToggle } from '@vaadin/react-components';
import { Suspense, useEffect } from 'react';
import { Outlet } from 'react-router-dom';

const defaultTitle = document.title;
const documentTitleSignal = signal('');
effect(() => {
  document.title = documentTitleSignal.value;
});

// Publish for Vaadin to use
(window as any).Vaadin.documentTitleSignal = documentTitleSignal;

export default function MainLayout() {
  // No longer using the SideNav or navigation logic
  useEffect(() => {
    documentTitleSignal.value = defaultTitle; // Set default title
  }, []);

  return (
    <AppLayout primarySection="drawer">
      {/* Removed the drawer section and SideNav */}
      <DrawerToggle slot="navbar" aria-label="Menu toggle" style={{ display: 'none' }}></DrawerToggle>
      <h1 slot="navbar" className="text-l m-0">
        {documentTitleSignal}
      </h1>

      <Suspense>
        <Outlet />
      </Suspense>
    </AppLayout>
  );
}
